package futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public class MemberAddressValidation extends AbstractFutureTask {

    public MemberAddressValidation(Callable<String> callable) {
        super(callable);
        futureTaskList.add(this);
    }

}
