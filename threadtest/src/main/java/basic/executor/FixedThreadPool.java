package basic.executor;

import basic.RunnableTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 * newFixedThreadPool 可以一次性的预先执行代价高昂的线程分配,因而也可以限制线程的数量了
 * 这样可以简省空间,因为你不用为每个任务都固定的付出创建线程的开销
 * 创建一个可重用固定线程数的线程池,以共享的无界队列方式来运行这些线程
 * 在任意点,线程会处理任务的活动状态.
 * 如果在所有线程处理活动状态时提交附加任务,则在由可用线程之前,附加任务将在队列中等待.
 * 如果在关闭前的执行期间由于失败而导致任何线程终止,那么一个新线程将代替它执行后续的任务
 * 在否个线程被显示地关闭之前,池中的线程将一只存在
 */
public class FixedThreadPool {
    public static void main(String [] args){
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            executorService.execute(new RunnableTest());
        }
        executorService.shutdown();
    }
}
