package basic.executor.threadreturnvalue;

import java.util.concurrent.Callable;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 * 作用:
 */
public class TaskWithResult implements Callable<String> {

    private int id;
    public TaskWithResult(int id){
        this.id=id;
    }
    public String call() throws Exception {
        return "result ="+this.id;
    }
}
