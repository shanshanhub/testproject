package testehcache;

import ehcache.Goods;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.instrument.Instrumentation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author WanChuanLai
 * @create 12/6/16.
 */
@ContextConfiguration(locations = {"classpath:spring-ehcache.xml"})
public class EhcacheTestNg extends AbstractTestNGSpringContextTests {
    @Autowired
    Ehcache recommendCache1;
    @Autowired
    Ehcache recommendCache2;
    @Autowired
    Ehcache recommendCache3;
    @Autowired
    Ehcache recommendCache4;
    @Autowired
    Ehcache recommendCache5;
    @Autowired
    Ehcache recommendCache6;
    @Autowired
    Ehcache recommendCache7;
    @Autowired
    Ehcache recommendCache8;
    @Autowired
    Ehcache recommendCache9;
    @Autowired
    Ehcache recommendCache10;

    Map<Long, Ehcache> map = new ConcurrentHashMap<Long, Ehcache>();

//    int i = 0;
//    int j = 0;
//    int count = 0;

    AtomicLong atomicLong = new AtomicLong(0);
    AtomicLong puttotallong = new AtomicLong(0);
    AtomicLong gettotallong = new AtomicLong(0);


    @BeforeTest
    public void add() {
//        Goods goods = new Goods(0, 1, "", 1, 1, 1, 1, new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), 1, new Date(), 1, 1, true, new Date(), 1, new Date(), 1, 1);
//        for (int i = 0; i <=10000000; i++) {
//            goods.setId(i);
//            recommendCache1.put(new Element("goods#" + goods.getId(), goods));
//        }
//        map.put(1l, recommendCache1);
//        map.put(2l, recommendCache2);
//        map.put(3l, recommendCache3);
//        map.put(4l, recommendCache4);
//        map.put(5l, recommendCache5);
//        map.put(6l, recommendCache6);
//        map.put(7l, recommendCache7);
//        map.put(8l, recommendCache8);
//        map.put(9l, recommendCache9);
//        map.put(10l, recommendCache10);
    }
    @Test
    public void testaddOne(){
        Goods goods = new Goods(0, 1, "", 1, 1, 1, 1, new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), 1, new Date(), 1, 1, true, new Date(), 1, new Date(), 1, 1);
        long start = System.currentTimeMillis();
        for (int i = 0; i <100000; i++) {
            recommendCache1.put(new Element("goods#" + goods.getId(), goods, 0, 10));
        }
        System.out.println("; userAlltime=" + (System.currentTimeMillis() - start));
    }

    //    @Test(invocationCount = 100, threadPoolSize = 100)
    @Test
    public void testAddEhcache() {

        Long incrementvalue = atomicLong.incrementAndGet();
        if (incrementvalue == 1L) {
            map.put(1l, recommendCache1);
            map.put(2l, recommendCache2);
            map.put(3l, recommendCache3);
            map.put(4l, recommendCache4);
            map.put(5l, recommendCache5);
            map.put(6l, recommendCache6);
            map.put(7l, recommendCache7);
            map.put(8l, recommendCache8);
            map.put(9l, recommendCache9);
            map.put(0l, recommendCache10);
        }
        System.out.println("incrementvalue=" + incrementvalue);
        Long intvalue = (incrementvalue % 10);
        System.out.println(intvalue);
        Ehcache recommendCache = map.get(intvalue);
//        if (recommendCache == null) {
////            map.put(intvalue, recommendCache1);
//            switch (intvalue.intValue()) {
//                case 1:
//                    map.put(1l, recommendCache1);
//                case 2:
//                    map.put(2l, recommendCache2);
//                case 3:
//                    map.put(3l, recommendCache3);
//                case 4:
//                    map.put(4l, recommendCache4);
//                case 5:
//                    map.put(5l, recommendCache5);
//                case 6:
//                    map.put(6l, recommendCache6);
//                case 7:
//                    map.put(7l, recommendCache7);
//                case 8:
//                    map.put(8l, recommendCache8);
//                case 9:
//                    map.put(9l, recommendCache9);
//                case 10:
//                    map.put(10l, recommendCache10);
//            }
//
//        }
        long start = System.currentTimeMillis();
        long perPutOneMillion = 0L;
        long perGetOneMillion = 0L;
        long getoneStart = 0;
        long oneStart = 0;
        long spiltTime = 0;
        long getspiltTime = 0;
        Element element = null;
        Goods goods = new Goods(0, 1, "", 1, 1, 1, 1, new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), 1, new Date(), 1, 1, true, new Date(), 1, new Date(), 1, 1);
        for (int i = 0; i <10; i++) {
//            Long oneStart=System.nanoTime();
            oneStart = System.nanoTime();
            goods.setId(i);

            map.get(intvalue).put(new Element("goods#" + goods.getId(), goods, 0, 10));
//            try {
//                Thread.sleep(2000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if(i==0){
                element = map.get(intvalue).get("goods#"+goods.getId());
//            }

//            System.out.println("ontusertime="+i+";"+(System.nanoTime()-oneStart));
            //puttotallong.addAndGet((System.nanoTime() - oneStart));
//            perPutOneMillion = perPutOneMillion + ((System.nanoTime() - oneStart));
//
//            if (i != 0 && ((i % 1) == 0)) {
//                System.out.println(intvalue + "; i=" + i + ";perOneMillionPut" + (perPutOneMillion / 1) + ";total=" + perPutOneMillion);
//                perPutOneMillion = 0L;
//            }


            //获取

            getoneStart = System.nanoTime();
            //  element = map.get(intvalue).get("goods#" + goods.getId());
            // gettotallong.addAndGet((System.nanoTime() - getoneStart));
//            perGetOneMillion = perGetOneMillion + ((System.nanoTime() - getoneStart));
//
//            if (i != 0 && ((i % 1) == 0)) {
//                System.out.println(intvalue + "; i=" + i + ";perOneMillionget" + (perGetOneMillion / 1) + ";total=" + perGetOneMillion);
//                perGetOneMillion = 0L;
//            }


//            if (spiltTime > 10)
//                System.out.println("ontputtime=" + i + ";" + spiltTime);
//            get("goods#" + goods.getId());
        }
        try {
            Thread.sleep(15000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        element = map.get(intvalue).get("goods#4");
        map.get(intvalue).put(new Element("goods#" + 10, goods, 0, 10));

        for (int i=0;i<11;i++){
            System.out.println("is disk:"+i+";"+map.get(intvalue).isElementOnDisk("goods#"+i));
        }

        map.get(intvalue).evictExpiredElements();

        for (int i=0;i<11;i++){
            System.out.println("is disk:"+i+";"+map.get(intvalue).isElementOnDisk("goods#"+i));
        }

        for (int i=0;i<11;i++){
            System.out.println("is disk:"+i+";"+map.get(intvalue).isElementInMemory("goods#"+i));
        }

        System.out.println(intvalue + "; userAlltime=" + (System.currentTimeMillis() - start));
        System.out.println(intvalue + "; memorySize=" + map.get(intvalue).calculateInMemorySize());
        System.out.println(intvalue + "; diskSize=" + map.get(intvalue).calculateOnDiskSize());
        System.out.println(intvalue + "; size:" + map.get(intvalue).getSize());

    }

    @AfterTest
    public void after() {
//        System.out.println("put avg:"+puttotallong.intValue()+";" + (puttotallong.intValue() / 100000));
//        System.out.println("get avg:" + gettotallong.intValue()+";"+(gettotallong.intValue() / 100000));
    }

//    public void get(String key) {
//        Long oneStart = System.currentTimeMillis();
//        Element element = this.recommendCache.get(key);
//        Long spiltTime = (System.currentTimeMillis() - oneStart);
//        if (spiltTime > 10)
//            System.out.println("onegettime=" + key + ";" + spiltTime);
//        if (element == null) {
//            System.out.println("onegettime is null");
//        }
//    }

    public static long getObjectSize(Goods o) {
        if (o == null) {
            return 0;
        }
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(buf);
            out.writeObject(o);
            out.flush();
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return buf.size();

    }
}
