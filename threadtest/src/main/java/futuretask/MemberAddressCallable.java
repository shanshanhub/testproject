package futuretask;

import java.util.concurrent.Callable;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public class MemberAddressCallable implements Callable<String> {
    public String call() throws Exception {
        System.out.println("doneACallable="+Thread.currentThread().getId());
        System.out.println("A begin------------");
        Thread.sleep(1000);
        System.out.println("A end------------");
        return "false";
    }
}
