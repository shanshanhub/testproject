package test;

import java.util.concurrent.RecursiveTask;

/**
 * @author WanChuanLai
 * @create 8/19/16.
 */
public class DemoA  extends RecursiveTask<Integer> {
    private int start;
    private int end;

    public DemoA(int start, int end) {
        this.start = start;
        this.end = end;
    }

    //计算
    @Override
    protected Integer compute() {
        int sum = 0;
        if (start - end < 100) {
            for (int i = start; i < end; i++) {
                sum += i;
            }
        } else {//间隔有100则拆分多个任务计算
            int middle = (start + end) / 2;
            DemoA left = new DemoA(start, middle);
            DemoA right = new DemoA(middle + 1, end);
            left.fork();
            right.fork();

            sum = left.join() + right.join();
        }
        return sum;
    }
}
