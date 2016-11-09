package futuretask;

import java.util.concurrent.Callable;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public class DeliveryAreaValidation extends AbstractFutureTask {
    public DeliveryAreaValidation(Callable<String> callable) {
        super(callable);
        futureTaskList.add(this);
    }
}
