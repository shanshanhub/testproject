package ehcache;

import net.sf.ehcache.*;
import net.sf.ehcache.event.CacheEventListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author WanChuanLai
 * @create 12/6/16.
 * spring ehcache test
 */
public class TestMain {
    public static void main(String[] args) {

        springCreate();

//         create();

    }

    public static void springCreate() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-ehcache.xml"});
        context.start();

        Ehcache ehcache = (Ehcache) context.getBean("recommendCache1");
        CacheEventListenerAdapter cacheEventListenerAdapter = new CacheEventListenerAdapter(ehcache);
        ehcache.getCacheEventNotificationService().registerListener(cacheEventListenerAdapter);



        Element element = new Element("key1", "value", 0, 60 * 60);
        ehcache.put(element);
        System.out.println("getkey1"+ehcache.get("key1").getObjectValue());
        System.out.println("getkey1"+ehcache.get("key1").getObjectValue());

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        element = new Element("key2", "value2", 0, 60 * 60);
        ehcache.put(element);
        System.out.println("getkey2"+ehcache.get("key2").getObjectValue());

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        element = new Element("key3", "value3", 0, 60 * 60);
        ehcache.put(element);
        System.out.println("getkey3"+ehcache.get("key3").getObjectValue());


        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("getkey1"+ehcache.get("key1").getObjectValue());


        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element = new Element("key4", "value4", 0, 60 * 60);
        ehcache.put(element);
        System.out.println("getkey4"+ehcache.get("key4").getObjectValue());

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        element = new Element("key5", "value5", 0, 60 * 60);
        ehcache.put(element);
        System.out.println("getkey5"+ehcache.get("key5").getObjectValue());

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        element = new Element("key6", "value6", 0, 60 * 60);
        ehcache.put(element);

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ehcache.get("key6").getObjectValue());

    }

    public static void create() {
        //创建一个缓存管理器

        CacheManager singletonManager = CacheManager.create();

        //在内存管理器中添加缓存实例
        Cache ehcache = new Cache("testCache", 10, false, true, 0, 60 * 60);
        singletonManager.addCache(ehcache);
//        CacheEventListenerAdapter cacheEventListenerAdapter = new CacheEventListenerAdapter(ehcache);
//        ehcache.getCacheEventNotificationService().registerListener(cacheEventListenerAdapter);


        Element element = new Element("key", "value");
        ehcache.put(element);
        System.out.println(ehcache.get("key").getObjectValue());
    }

    private static class CacheEventListenerAdapter implements CacheEventListener, Cloneable {

        private Ehcache ehCache;

        public CacheEventListenerAdapter(Ehcache ehCache) {
            this.ehCache = ehCache;
        }


        public void notifyElementRemoved(Ehcache cache, Element element) throws CacheException {
            if (cache.equals(ehCache)) {

            }
        }


        public void notifyElementPut(Ehcache cache, Element element) throws CacheException {
            if (cache.equals(ehCache)) {
                System.out.println("put key:" + element.getObjectKey());
            }
        }


        public void notifyElementUpdated(Ehcache cache, Element element) throws CacheException {
            if (cache.equals(ehCache)) {

            }
        }


        public void notifyElementExpired(Ehcache cache, Element element) {
            if (cache.equals(ehCache)) {
                System.out.println("expired key:" + element.getObjectKey());
            }
        }


        public void notifyElementEvicted(Ehcache cache, Element element) {
            if (cache.equals(ehCache)) {
                System.out.println("Evicted key:" + element.getObjectKey());
            }
        }


        public void notifyRemoveAll(Ehcache cache) {
            if (cache.equals(ehCache)) {

            }
        }


        public void dispose() {
        }

        @Override
        public CacheEventListenerAdapter clone() throws CloneNotSupportedException {
            CacheEventListenerAdapter clone = (CacheEventListenerAdapter) super.clone();
            clone.ehCache = (Ehcache) ehCache.clone();
            return clone;
        }
    }
}
