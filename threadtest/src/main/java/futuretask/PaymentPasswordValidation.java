package futuretask;

import java.util.concurrent.Callable;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public class PaymentPasswordValidation extends AbstractFutureTask {
    public PaymentPasswordValidation(Callable<String> callable) {
        super(callable);
        futureTaskList.add(this);
    }
}
