package basic.component.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public class TaskPortion implements Runnable {
    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch){
        this.latch=latch;
    }
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();

    }

    public String toString(){
        return "taskportion id=";
    }

}
