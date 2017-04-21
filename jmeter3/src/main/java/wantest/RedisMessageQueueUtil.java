package wantest;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author WanChuanLai
 * @create 12/24/16.
 */
public class RedisMessageQueueUtil {

    // 默认通道
    public static String DEFAULT_CHANNEL = "defaultwan";
    // Redis服务停止，客户端重连次数
    private static int retryConnectTimes = 0;

    /**
     * 订阅默认通道消息
     */
    public static void subscribe(JedisPubSub pubSub) {
        subscribe(pubSub, DEFAULT_CHANNEL);
    }

    /**
     * 根据指定通道订阅消息
     */
    public static void subscribe(JedisPubSub pubSub, String channel) {
        boolean isRetryConnect = false;        // 是否重试连接
        do {
            try {
                Jedis jedis = RedisProvider.getResource();
                if (jedis.isConnected()) {
                    retryConnectTimes = 0;
                    isRetryConnect = false;
                }
                jedis.subscribe(pubSub, channel);
            } catch (JedisConnectionException e) {
                retryConnectTimes++;
                isRetryConnect = true;
                System.out.println("Redis订阅尝试重新连接次数：" + retryConnectTimes);
                try {
                    Thread.currentThread().sleep(2000 * retryConnectTimes);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        } while (isRetryConnect);
    }

    /**
     * 使用默认通道发布消息
     *
     * @param message
     */
    public static void publish(String message) {
        publish(message, DEFAULT_CHANNEL);
    }

    /**
     * 发布消息到指定通道
     *
     * @param message
     */
    public static void publish(String message, String channel) {
        Jedis jedis = RedisProvider.getResource();
        jedis.publish(channel, message);
        // 归还连接
        RedisProvider.returnResource(jedis, false);
    }

    private static AtomicInteger key = new AtomicInteger(0);

    public static void main(String args[]) {
        JSONObject jitem = new JSONObject();
        jitem.put("keyName", key.incrementAndGet());
        jitem.put("publishTime", System.currentTimeMillis());
        publish(jitem.toJSONString());


//		publish(message.toJSONString(), "default");
//		subscribe(new LocalCacheRemoveSub());
//		subscribe(new LocalCacheRemoveSub(), "default");
    }
}
