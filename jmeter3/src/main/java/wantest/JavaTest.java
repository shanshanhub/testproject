package wantest;

import com.alibaba.fastjson.JSONObject;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author WanChuanLai
 * @create 12/22/16.
 */
public class JavaTest extends AbstractJavaSamplerClient {


    static MemcachedClient basicMemcachedClient;
    static Cache ehcache;
    static int fileSize;
    static String testType;
    static int count;
    static String operatorType;
    static int processCount;
    static Jedis jedis;

    // main只是为调试用，最好先调试再打包
//运行前请把jmeter_home/lib下的所有jar包加载到IDE工具环境变量
    public static void main(String[] args) {

        Arguments args0 = new Arguments();
        args0.addArgument("fileSize", "0");
        args0.addArgument("testType", "redis");
        args0.addArgument("count", "100");

        args0.addArgument("operatorType", "publish");

        args0.addArgument("processCount", "2");

        JavaTest test = new JavaTest();
        JavaSamplerContext context = new JavaSamplerContext(args0);
        test.setupTest(context);
        test.runTest(context);
        test.teardownTest(context);
    }

    /**
     * 实现 runTest(JavaSamplerContext context)方法
     * runTest()具体实施测试动作
     */
    public SampleResult runTest(JavaSamplerContext context) {
        System.out.println("adfasdfasdf");
    /*
     *  SampleResult只能定义为局部变量，避免出现多线程安全问题
     *  网上一些帖子，定义为全域变量，这种做法是错误的
     */
        SampleResult results = new SampleResult();
        //默认请求成功
        results.setSuccessful(true);
        String key = random(count);
        Object value = getObject(fileSize);

        results.sampleStart(); //记录响应时间开始
        for (int i = 0; i < processCount; i++) {
            try {
                if (testType.equals("memcache")) {
                    if (operatorType.equals("get")) {
                        testGetMemcache(key);
                    } else if (operatorType.equals("set")) {
                        testMemcache(key, value);
                    }

                } else if (testType.equals("ehcache")) {
                    if (operatorType.equals("get")) {
                        testGetEhcache(key);
                    } else if (operatorType.equals("set")) {
                        testEhcache(key, value);
                    }
                } else if (testType.equals("redis")) {
                    if (operatorType.equals("get")) {
                        testGetEhcache(key);
                    } else if (operatorType.equals("set")) {
                        testSetRedis(key, value);
                    } else if (operatorType.equals("publish")) {
                        testpublishRedis(value);
                    }

                }

            } catch (Throwable e) {
                e.printStackTrace();
                results.setSuccessful(false);
                //处理异常堆栈为String，只有String才能回写响应数据
                results.setResponseData(toStringStackTrace(e), "utf8");
            }
        }
        results.sampleEnd(); //记录响应时间结束
        return results;
    }


    /**
     * 测试开始时调用，初始化
     */
    public void setupTest(JavaSamplerContext context) {
        testType = context.getParameter("testType");
        if (testType.equals("memcache")) {
            if (basicMemcachedClient == null) {
                System.out.println("basicMemcachedClient is null");
                ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext(new String[]{"spring-memcache.xml"});
                basicMemcachedClient = (MemcachedClient) springContext.getBean("basicMemcachedClient");
            } else {
                System.out.println("basicMemcachedClient is not null");
            }
        } else if (testType.equals("ehcache")) {
            //创建一个缓存管理器

            CacheManager singletonManager = CacheManager.create();
            //在内存管理器中添加缓存实例
            ehcache = singletonManager.getCache("testCache");
            if (ehcache == null) {
                System.out.println("testCache is null");
                ehcache = new Cache("testCache", 10000000, false, true, 0, 60 * 60);
                singletonManager.addCache(ehcache);
            } else {
                System.out.println("testCache is not null");
            }
        }


        //文件大小
        fileSize = Integer.valueOf(context.getParameter("fileSize"));
        count = Integer.valueOf(context.getParameter("count"));

        operatorType = context.getParameter("operatorType");

        processCount = Integer.valueOf(context.getParameter("processCount"));
        //压测类型(memcache ehcache redis)

        System.out.println("fileSize:" + fileSize + ";count:" + count + ";testType:" + testType);
    }

    /**
     * 测试结束时调用
     */
    public void teardownTest(JavaSamplerContext context) {
    }

    /**
     * 定义默认参数
     */
    @Override
    public Arguments getDefaultParameters() {
        Arguments args = new Arguments();
    /*
     * test data
     */
        args.addArgument("fileSize", "1");
        args.addArgument("testType", "memcache");
        args.addArgument("count", "100");
        args.addArgument("operatorType", "get");
        args.addArgument("processCount", "1000");
        return args;
    }

    /**
     * 处理异常堆栈为String，只有String才能回写响应数据
     *
     * @param e
     * @return
     */
    private String toStringStackTrace(Throwable e) {
        String exception = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            exception = sw.toString();
            pw.close();
            sw.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return exception;
    }


    public static boolean testMemcache(String key, Object value) {
        try {
//            System.out.println("memcache setkey:" + key);
            basicMemcachedClient.add(key, 60 * 60, value);
//            System.out.println("memcache getkey:" + basicMemcachedClient.get(key));
            return true;
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return false;

    }


    public static boolean testGetMemcache(String key) {
        try {
//            System.out.println("memcache setkey:" + key);
            basicMemcachedClient.get(key);
//            System.out.println("memcache getkey:" + basicMemcachedClient.get(key));
            return true;
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return false;

    }


    public static void testEhcache(String key, Object value) {
//        System.out.println("ehcache setkey:" + key);
        ehcache.put(new Element(key, value));
//        System.out.println("ehcache getkey:" + ehcache.get(key).getObjectValue());

    }

    public static void testGetEhcache(String key) {
//        System.out.println("ehcache setkey:" + key);
        ehcache.get(key);
//        System.out.println("ehcache getkey:" + ehcache.get(key).getObjectValue());

    }

    private static AtomicInteger key = new AtomicInteger(0);


    public static void testpublishRedis(Object value) {

        RedisMessageQueueUtil.publish("{\"publishTime\":" + System.currentTimeMillis() + ",\"keyName\":" + key.incrementAndGet() + ",\"value\":\"" + value + "\"}", "default");


    }

    public static void testGetRedis(String key) {

        jedis.get(key);

    }

    public static void testSetRedis(String key, Object value) {
        jedis.set(key, value.toString());

    }


    /**
     * 根据大小获取对象
     * 1=1kb 2=10kb 3=1mb
     *
     * @param size
     * @return
     */
    public static Object getObject(int size) {

        List<Goods> goodsList = new ArrayList<Goods>();
        if (size == 1) {
            Goods goods = new Goods(1, 1, "万测试测试测试wan", 121212, 1, 1, 1, new BigDecimal(12345), new BigDecimal(232323), new BigDecimal(1212121), 234234, new Date(), 234234, 1, true, new Date(), 23432423, new Date(), 1, 1, "传传传传", "来来来来wa");
            goodsList.add(goods);
        } else if (size == 2) {
            for (int i = 0; i < 35; i++) {
                Goods goods = new Goods(1, 1, "万测试测试测试wan", 121212, 1, 1, 1, new BigDecimal(12345), new BigDecimal(232323), new BigDecimal(1212121), 234234, new Date(), 234234, 1, true, new Date(), 23432423, new Date(), 1, 1, "传传传传", "来来来来wa");
                goodsList.add(goods);
            }
        } else if (size == 3) {
            for (int i = 0; i < 4000; i++) {
                Goods goods = new Goods(1, 1, "万测试测试测试wan", 121212, 1, 1, 1, new BigDecimal(12345), new BigDecimal(232323), new BigDecimal(1212121), 234234, new Date(), 234234, 1, true, new Date(), 23432423, new Date(), 1, 1, "传传传传", "来来来来wa");
                goodsList.add(goods);
            }
        } else if (size == 0) {
            return "wanchuanlaiwanchuanlaiwanchuanla";
        }
        return goodsList;
    }

    /**
     * 随机生成{count}以内的随机数
     */
    public static String random(int count) {
        Random random = new Random();
        int n = random.nextInt(count);
        return String.valueOf(n);
    }

}
