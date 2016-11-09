package forkjoin.Work;

import java.util.UUID;
import java.util.concurrent.RecursiveTask;

/**
 * @author WanChuanLai
 * @create 8/23/16.
 */
public class WorkB extends RecursiveTask<String> {
    private String key;
    public WorkB(String key){
        super();
        this.key=key;
    }
    @Override
    protected String compute() {
        return key+ UUID.randomUUID();
    }
}
