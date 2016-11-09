package threadtest;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public interface CheckCallBackService {
    boolean callBack(boolean isSuccess,int errorCode,Object ... objects);
}
