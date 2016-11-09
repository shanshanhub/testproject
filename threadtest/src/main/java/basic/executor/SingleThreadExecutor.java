package basic.executor;

import basic.RunnableTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 * 就像是线程数量为1的FixedThreadPool,
 * 这对你希望在另一个线程中持续运行的任务事物(长期存活的任务)来说,是很有用的.例如监听进入的套接字链接的任务
 * 它对于希望在线程中运行的短任务也同样很方便,例如,更新本地或远程日志的小任务,或者是时间分发程序
 * 如果向SingleThreadExecutor提交了多个任务,那么这些任务会排队,每个任务会在下一个任务开始之前运行结束,
 * 所有的任务将使用相同的线程.
 * SingleThreadExecutor 会系列化所有提交给它的任务,并维护它自己的悬挂任务队列
 *
 *
 *创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
 * （注意，如果因为在关闭前的执行期间出现失败而终止了此单个线程，那么如果需要，一个新线程将代替它执行后续的任务）。
 * 可保证顺序地执行各个任务，并且在任意给定的时间不会有多个线程是活动的。
 * 与其他等效的 newFixedThreadPool(1) 不同，可保证无需重新配置此方法所返回的执行程序即可使用其他的线程
 */
public class SingleThreadExecutor {
    public static void main(String [] args){
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        for (int i=0;i<5;i++){
            executorService.execute(new RunnableTest());
        }
        executorService.shutdown();
    }
}
