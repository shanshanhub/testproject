package basic.component.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 * 作用:他被用来同步一个或多个任务,强制它们等待由其它任务执行的一组操作完成
 *
 * 任何在这个对象上调用wait()的方法都将阻塞,直至这个计数器到0.
 * 其它任务在结束工作时,可以在该对象上调用countDown来减少这个计数器
 *
 * 在调用wait()时,会堵塞,在调用countDown时不会堵塞
 *
 */
public class CountDownLatchTest {
    static final int size=100;
    public static void main(String [] args){
        ExecutorService executorService= Executors.newCachedThreadPool();
        CountDownLatch countDownLatch=new CountDownLatch(size);
        for (int i=0;i<10;i++){
            executorService.execute(new WaitingTask(countDownLatch));
        }
        for (int i=0;i<size;i++){
            executorService.execute(new TaskPortion(countDownLatch));
        }
        executorService.shutdown();
    }

}
