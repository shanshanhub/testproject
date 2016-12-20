package cache;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author WanChuanLai
 * @create 12/19/16.
 * 1,一级缓存和二级缓存都是可定义的.
 * 暂定一级缓存为ehcache
 * 二级缓存为memcache
 */
public class CacheManager {

    private final Cache cache = new MapCache();
    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
//
//    public CacheManager(Cache cacheLevel1, Cache cacheLevel2) {
//        this.cacheLevel1 = cacheLevel1;
//        this.cacheLevel2 = cacheLevel2;
//    }

    public Object get(String cacheName, String key, CacheDataFrom cacheDataFrom) {
        //先暂时考虑一级缓存的事
        //1,如果一级缓存可以直接读取,直接从一级缓存取
        //2,如果一级缓存读取不到,从二级缓存读,
        //从二级缓存读取到后,存到一级缓存
        //这个时候要考虑并发的问题
        //这里用读写锁考虑
        Object value = null;
        rwl.readLock().lock();
        System.out.println(Thread.currentThread().getName() + " be ready to read data!");
        try {
            value = this.cache.get(key);
            System.out.println(Thread.currentThread().getName() + " have read data :" + value);
            if (value == null) {
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + " be ready to write data!");
                try {
//                        value = this.cacheLevel2.get(key);
//                        if (value != null) {
//                            this.cacheLevel1.put(key, value);
//                        }
//                        value = "aaaa";//测试读写锁用
                    value = cacheDataFrom.putData();
                    System.out.println(Thread.currentThread().getName() + " have  write data: " + value);
                    rwl.readLock().lock();
                } finally {
                    rwl.writeLock().unlock();
                }
            }
        } finally {
            rwl.readLock().unlock();

        }
        return value;

    }


    public static void main(String[] args) {
        final CacheManager cacheManager = new CacheManager();
        for (int i = 0; i < 3; i++) {
            new Thread() {
                public void run() {
                    while (true) {
                        cacheManager.get("cache", "AA", new CacheDataFrom() {
                            public Object putData() {
                                return "aaaa";
                            }
                        });
                    }
                }

            }.start();
        }


    }

}
