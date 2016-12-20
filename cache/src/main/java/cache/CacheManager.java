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

    public Object get(String cacheName, String key, CacheDataFrom cacheDataFrom) {
        //这个时候要考虑并发的问题,如果都在从缓存里面读取数据,刚好这个时候又过期了,这个时候,获取写锁,其它读锁都处于等待状态.
        //这里用读写锁考虑
        // 读的时候上读锁,写的时候上写锁
        Object value = null;
        rwl.readLock().lock();
        System.out.println(Thread.currentThread().getName() + " be ready to read data! key:"+key);
        try {
            Thread.sleep((long) (Math.random() * 1000));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            value = this.cache.get(key);
            System.out.println(Thread.currentThread().getName() + " have read key:"+key+" data :" + value);
        } finally {
            rwl.readLock().unlock();

        }
        if (value == null) {
            rwl.writeLock().lock();
            try {
                Thread.sleep((long) (Math.random() * 1000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " be ready to write key:"+key+" data!");
            try {
                value = cacheDataFrom.putData();
                if (value != null) {
                    this.cache.put(key, value);
                }
//                        value = "aaaa";//测试读写锁用

                System.out.println(Thread.currentThread().getName() + " have  write key:"+key+" data: " + value);

            } finally {
                rwl.writeLock().unlock();
            }
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
                                return (Math.random() * 1000);
                            }
                        });
                    }
                }

            }.start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread() {
                public void run() {
                    while (true) {
                        cacheManager.get("cache", "BB", new CacheDataFrom() {
                            public Object putData() {
                                return (Math.random() * 1000);
                            }
                        });
                    }
                }

            }.start();
        }


    }

}
