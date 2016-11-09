package comall.future;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author WanChuanLai
 * @create 8/25/16.
 */
public class AbstractWorkCheckCallBack implements WorkCheckCallBack{

    private volatile Object [] result;
    private volatile Throwable failure;

    private final CountDownLatch latch = new CountDownLatch(1);

    public void onSuccess(Object... objects) {
        this.result=objects;
        latch.countDown();
    }

    public void onFailure(Throwable cause) {
        this.failure=cause;
        latch.countDown();
    }


    public Object [] get() throws InterruptedException, ExecutionException {
        if (!isDone()) {
            latch.await();
        }
        return getFutureResult();
    }



    public boolean isDone() {
        return latch.getCount() == 0L;
    }

    private Object [] getFutureResult() throws ExecutionException {
        if (failure != null) {
            throw new ExecutionException(failure);
        } else {
            return result;
        }
    }

    /**
     * 等待多长时间就不等待了
     * @param timeout
     * @param unit
     * @return
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public Object []  get(long timeout, TimeUnit unit) throws TimeoutException, InterruptedException, ExecutionException {
        if (!isDone() && !latch.await(timeout, unit)) {
            throw new TimeoutException("A Timeout occurred while waiting for a  Callback");
        }
        return getFutureResult();
    }
}
