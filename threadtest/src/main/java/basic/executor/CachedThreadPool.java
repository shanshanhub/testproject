package basic.executor;

import basic.RunnableTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 * 在执行过程中,通常会创建与所需数量相同的线程,然后在它回收旧线程时停止创建新线程.
 * 创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。
 * 对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能。
 * 调用 execute 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
 * 因此，长时间保持空闲的线程池不会使用任何资源
 *
 * 因此,它是Executor的首选,只有当这种方式引起不当时,你才需要切换到FixedThreadPool
 */
public class CachedThreadPool {
    public static void main(String [] args){
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            executorService.execute(new RunnableTest());
        }
        executorService.shutdown();
    }
}
