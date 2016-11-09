package test;

import java.util.concurrent.RecursiveTask;

/**
 * @author WanChuanLai
 * @create 8/19/16.
 */
public class DemoB extends RecursiveTask<Integer> {

    private String type;
    public DemoB(String type){
        this.type=type;
    }
    @Override
    protected Integer compute() {
        DemoB left = new DemoB("create");
        DemoB right = new DemoB("update");
        left.fork();
        right.fork();
        return left.join()+right.join();
    }
}
