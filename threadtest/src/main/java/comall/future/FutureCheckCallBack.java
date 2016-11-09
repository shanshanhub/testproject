package comall.future;

/**
 * @author WanChuanLai
 * @create 8/25/16.
 */
public interface FutureCheckCallBack {
    void callBack(boolean isSuccess,int errorCode,Object ... objects);
}
