package comall.future.test;

import comall.future.FutureCheck;
import comall.future.work.WorkA;
import comall.future.work.WorkB;
import comall.future.work.WorkC;

import java.util.concurrent.ExecutionException;

/**
 * @author WanChuanLai
 * @create 8/25/16.
 */
public class TestMain {
    public static void main(String [] args){
        long begin = System.currentTimeMillis();
        System.out.println("begin=" + begin);
        int i=2;
        OrderCreateCallBack orderCreateCallBack=new OrderCreateCallBack(i);
        FutureCheck futureCheck=new FutureCheck(orderCreateCallBack);
        futureCheck.execute(new WorkA(),new WorkB(),new WorkC());
        Object [] objects=null;
        try {
            objects= orderCreateCallBack.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("i="+objects[0]);
    }
}
