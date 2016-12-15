import memcache.Goods;
import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author WanChuanLai
 * @create 12/12/16.
 */
@ContextConfiguration(locations = {"classpath:spring-cache.xml"})
public class TestMemcache extends AbstractTestNGSpringContextTests {
    @Autowired
    MemcachedClient basicMemcachedClient;

    Map<Long, MemcachedClient> map = new ConcurrentHashMap<Long, MemcachedClient>();
    @Test
    public void add(){

        long start = System.currentTimeMillis();
        long perPutOneMillion = 0L;
        long perGetOneMillion = 0L;
        long getoneStart = 0;
        long oneStart = 0;
        long spiltTime = 0;
        long getspiltTime = 0;
        Goods goods = new Goods(0, 1, "", 1, 1, 1, 1, new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), 1, new Date(), 1, 1, true, new Date(), 1, new Date(), 1, 1);
        for (int i = 0; i <= 100000; i++) {
//            Long oneStart=System.nanoTime();
            oneStart = System.nanoTime();
            goods.setId(i);

            map.get(intvalue).put(new Element("goods#" + goods.getId(), goods));
//            System.out.println("ontusertime="+i+";"+(System.nanoTime()-oneStart));
            //puttotallong.addAndGet((System.nanoTime() - oneStart));
            perPutOneMillion = perPutOneMillion + ((System.nanoTime() - oneStart));

            if (i != 0 && ((i % 100000) == 0)) {
                System.out.println(intvalue + "; i=" + i + ";perOneMillionPut" + (perPutOneMillion / 100000) + ";total=" + perPutOneMillion);
                perPutOneMillion = 0L;
            }


            //获取

            getoneStart = System.nanoTime();
            element = map.get(intvalue).get("goods#" + goods.getId());
            // gettotallong.addAndGet((System.nanoTime() - getoneStart));
            perGetOneMillion = perGetOneMillion + ((System.nanoTime() - getoneStart));

            if (i != 0 && ((i % 100000) == 0)) {
                System.out.println(intvalue + "; i=" + i + ";perOneMillionget" + (perGetOneMillion / 100000) + ";total=" + perGetOneMillion);
                perGetOneMillion = 0L;
            }


//            if (spiltTime > 10)
//                System.out.println("ontputtime=" + i + ";" + spiltTime);
//            get("goods#" + goods.getId());
        }
        System.out.println(intvalue + "; userAlltime=" + (System.currentTimeMillis() - start));
//        System.out.println(intvalue + "; memorySize=" + map.get(intvalue).calculateInMemorySize());
//        System.out.println(intvalue + "; diskSize=" + map.get(intvalue).calculateOnDiskSize());
        System.out.println(intvalue + "; size:" + map.get(intvalue).getSize());

    }
}
