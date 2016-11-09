package forkjoin.Work;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * @author WanChuanLai
 * @create 8/23/16.
 */
public class WorkDemo extends RecursiveTask<String> {
    private String key;
    public WorkDemo(String key){
        this.key=key;
    }
    @Override
    protected String compute() {
        List<RecursiveTask<String>> forks =new LinkedList<RecursiveTask<String>>();
        WorkDemo workDemo=new WorkDemo("workA");
        forks.add(workDemo);
        workDemo.fork();
        WorkB workB=new WorkB("workB");
        forks.add(workB);
        workB.fork();
        String result="";
        for (RecursiveTask<String> task : forks) {
            result = result + task.join();
        }
        return result;


    }
}
