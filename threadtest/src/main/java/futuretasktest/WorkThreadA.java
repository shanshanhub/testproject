package futuretasktest;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author WanChuanLai
 * @create 8/19/16.
 */
public class WorkThreadA implements Callable<Object> {
    String work = "";
    CountDownLatch finishLatch;
    boolean isStop = true;

    public WorkThreadA(String work, CountDownLatch finishLatch, boolean isStop) {
        this.work = work;
        this.finishLatch = finishLatch;
        this.isStop = isStop;
    }

    public void stop() {
        this.isStop = true;
    }

    public Object call() throws Exception {
        System.out.println("A Threadid="+Thread.currentThread().getId());
        boolean result = false;
        if (this.work.equals("startA")) {
            System.out.println("A1------");
            Thread.sleep(1000);
            System.out.println("A2------");
            result = false;

        }

        isStop = true;
        System.out.println("countDown=" + finishLatch.getCount());
        System.out.println("子线程A=" + Thread.currentThread().getId() + "执行完毕");
        if (result) {
            finishLatch.countDown();
            System.out.println("AAAAACOUNTdOWN11111");
        } else {
            while (finishLatch.getCount() > 0) {
                System.out.println("AAAAACOUNTdOWN2222=" + finishLatch.getCount());
                finishLatch.countDown();
            }

        }
        return result;

    }
}
