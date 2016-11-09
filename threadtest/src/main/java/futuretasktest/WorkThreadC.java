package futuretasktest;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author WanChuanLai
 * @create 8/19/16.
 */
public class WorkThreadC implements Callable<Object> {
    String work = "";
    CountDownLatch finishLatch;
    boolean isStop = true;

    public WorkThreadC(String work, CountDownLatch finishLatch, boolean isStop) {
        this.work = work;
        this.finishLatch = finishLatch;
        this.isStop = isStop;

    }

    public void stop() {
        Thread.interrupted();
        //  this.isStop=true;
    }

    public Object call() throws Exception {
        System.out.println("C Threadid="+Thread.currentThread().getId());

        boolean result = true;
        if (this.work.equals("startC")) {
            System.out.println("c1------");
            Thread.sleep(5000);
            System.out.println("c2------");
            result = true;
        }
        if (result) {
            finishLatch.countDown();
            System.out.println("CCCCCCOUNTdOWN11111");
        } else {
            while (finishLatch.getCount() > 0) {
                System.out.println("CCCCCCOUNTdOWN2222=" + finishLatch.getCount());
                finishLatch.countDown();
            }

        }
        isStop = true;
        System.out.println("countDown=" + finishLatch.getCount());
        System.out.println("子线程C=" + Thread.currentThread().getId() + "执行完毕");

        return result;

    }
}
