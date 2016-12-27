package subscribe;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis服务
 *
 * @author Zero
 */
public class RedisProvider {
    // redis主机
    private static String HOST;
    // 端口号
    private static int PORT;
    // 认证密码
    private static String PASSWORD;
    //可用连接实例的最大数目，默认值为8
    private static int MAX_ACTIVE;
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE;
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT;
    //超时时间
    private static int TIMEOUT;
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;
    // redis配置文件
    private static final String REDIS_CONFIG_FILE = "redis.properties";
    private static JedisPool pool;

    static {
        HOST = "127.0.0.1";
        PASSWORD = "admin";
        PORT = 6379;
        MAX_ACTIVE = 1024;
        MAX_IDLE = 200;
        MAX_WAIT = 10000;
        TIMEOUT = 10000;
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            pool = new JedisPool(config, HOST, PORT, TIMEOUT,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     *
     * @param jedis            jedis instance
     * @param isBrokenResource resource is ok or not
     */
    public static void returnResource(Jedis jedis, boolean isBrokenResource) {
        if (null == jedis)
            return;

        if (isBrokenResource) {
            jedis.close();
            jedis = null;
        } else
            pool.returnResourceObject(jedis);

    }

    public static Jedis getResource() {
        return pool.getResource();
    }
}
