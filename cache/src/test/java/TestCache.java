import cache.Cache;
import cache.CacheManager;
import cache.MapCache;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author WanChuanLai
 * @create 12/19/16.
 */
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TestCache extends AbstractTestNGSpringContextTests {
    Cache cache1=new MapCache();
    Cache cache2=new MapCache();
    @Test(invocationCount = 5, threadPoolSize = 5)
    public void testReadWriteLock() {
        cache2.put("AA",new Random().nextInt(10000));
//        CacheManager cacheManager=new CacheManager(cache1,cache2);
//        cacheManager.get(1,"","AA");
    }

}
