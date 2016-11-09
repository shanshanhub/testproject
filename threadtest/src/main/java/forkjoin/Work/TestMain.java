package forkjoin.Work;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author WanChuanLai
 * @create 8/23/16.
 */
public class TestMain {
    public static void main(String[] args) throws Exception {

        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new WorkDemo("key"));

    }


}
