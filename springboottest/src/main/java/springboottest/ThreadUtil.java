package springboottest;


/**
 * <p>描述内容</br></p>
 *
 * @author liugaoyu Email:liugaoyu@co-mall.com
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018/3/2 10:04
 */
public class ThreadUtil {

    private ThreadUtil() {
    }
    public static ThreadPoolTaskExecutor initThreadTool() {
        ThreadPoolExecutor poolTaskExecutor = new ThreadPoolExecutor();
        //线程池所使用的缓冲队列
        //队列对打长度
        poolTaskExecutor.setQueueCapacity(100);
        //线程池维护线程的最少数量
        poolTaskExecutor.setCorePoolSize(5);
        //线程池维护线程的最大数量
        poolTaskExecutor.setMaxPoolSize(20);
        //线程池维护线程所允许的空闲时间
        poolTaskExecutor.setKeepAliveSeconds(3000);
        poolTaskExecutor.initialize();
        return poolTaskExecutor;
    }
}
