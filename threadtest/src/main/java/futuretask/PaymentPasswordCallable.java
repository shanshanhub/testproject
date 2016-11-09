package futuretask;

import java.util.concurrent.Callable;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public class PaymentPasswordCallable implements Callable<String> {
    public String call() throws Exception {
        System.out.println("doneCCallable="+Thread.currentThread().getId());
        System.out.println("B begin------------");
        Thread.sleep(3000);
        System.out.println("doneACallable="+Thread.currentThread().getId());
        System.out.println("B end------------");
        return "true";
    }
}
