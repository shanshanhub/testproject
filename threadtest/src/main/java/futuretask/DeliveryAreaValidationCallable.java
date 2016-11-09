package futuretask;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public class DeliveryAreaValidationCallable extends AbstractCallable {
    public String call() throws Exception {
        System.out.println("doneCCallable="+Thread.currentThread().getId());
        System.out.println("C begin------------");
        Thread.sleep(5000);
        System.out.println("doneACallable="+Thread.currentThread().getId());
        System.out.println("C end------------");
        return "true";
    }
}
