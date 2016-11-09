package test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author WanChuanLai
 * @create 8/19/16.
 */
public class ForkjoinTest {
    public static void main(String [] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();//对线程池的扩展
        Future<Integer> result = forkJoinPool.submit(new DemoA(1, 1000));

        System.out.println(result.get());
        forkJoinPool.shutdown();

    }

}
