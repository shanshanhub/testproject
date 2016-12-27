package subscribe;

import java.util.concurrent.Executors;

/**
 * @author WanChuanLai
 * @create 12/24/16.
 */
public class TestMain {
    public static void main(String[] args) {
        Executors.newCachedThreadPool().submit(new Runnable() {
            public void run() {
                System.out.println("＃＃＃订阅消息开始");
                // 订阅消息
                RedisMessageQueueUtil.subscribe(new LocalCacheRemoveSub());
            }
        });
    }
}
