package comall.future;

import java.util.concurrent.ExecutionException;

/**
 * @author WanChuanLai
 * @create 8/25/16.
 */
public interface WorkCheckCallBack {
    /**
     * 执行回调成功
     * @param objects 回调成功返回值
     */
    void onSuccess(Object ... objects);

    /**
     * 执行回调失败
     * @param cause 抛异常
     */
    void onFailure(Throwable cause);

    /**
     * 获取返回的值
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    Object[] get() throws InterruptedException, ExecutionException;

    /**
     * 是否回调完成
     * @return
     */
    boolean isDone();


}
