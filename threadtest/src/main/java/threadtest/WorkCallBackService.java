package threadtest;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public interface WorkCallBackService {
    void callBack(boolean isSuccess,int errorCode,Object ... objects);
}
