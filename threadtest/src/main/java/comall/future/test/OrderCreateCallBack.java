package comall.future.test;

import comall.future.AbstractWorkCheckCallBack;
import comall.future.WorkCheckCallBack;

/**
 * @author WanChuanLai
 * @create 8/25/16.
 */
public class OrderCreateCallBack extends AbstractWorkCheckCallBack {


    private  int i=0;
    public OrderCreateCallBack(int i){
        this.i=i;
    }

    public void onSuccess(Object... objects) {
        long end = System.currentTimeMillis();
        System.out.println("end=" + end);
        System.out.println("回调成功了哦");
        super.onSuccess(6);
       // this.i=6;
    }

    public void onFailure(Throwable cause) {
        System.out.println("回调失败了哦="+cause);
    }
}
