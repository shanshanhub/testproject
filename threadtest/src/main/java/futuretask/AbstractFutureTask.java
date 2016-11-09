package futuretask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public abstract class AbstractFutureTask extends FutureTask<java.lang.String> {

    final  static  List<FutureTask<String>> futureTaskList= Collections.synchronizedList(new ArrayList<FutureTask<String>>());


    public AbstractFutureTask(Callable<String> callable) {
        super(callable);
    }

    @Override
    protected void done(){
        System.out.println("done="+Thread.currentThread().getId());
        String result="";
        try {
            result=get();
            cancelFutureTask(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("线程执行完毕="+result);
    }

    public void cancelFutureTask(String result){
        System.out.println("futureTaskList="+futureTaskList.size());
        if(result.equals("false")){
            for (FutureTask<String> futureTask:futureTaskList) {
                futureTask.cancel(true);
            }
        }

    }


}

