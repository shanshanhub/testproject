package basic.component.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public class WaitingTask implements Runnable {
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch){
        this.latch=latch;
    }

    public void run() {
        try {
            this.latch.wait();
            System.out.println("其它的任务完成了 latch=");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return "waitiontask id";
    }

}
