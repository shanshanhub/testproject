package basic;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 * 线程可以驱动任务,因此你需要一种描述任务的方式.
 * 这个由Runnable接口提供,任务只需要实现run方法
 * 例如:下面的任务将显示发射之前的倒计时
 *
 *
 */
public class RunnableTest implements Runnable{

    protected int countDown=10;
    private static int taskCount=0;
    private static final int id=taskCount++;
    public RunnableTest(){}

    public RunnableTest(int countDown){
        this.countDown=countDown;
    }
    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"0了哦")+")";
    }

    public void run() {
        System.out.println("threadid="+Thread.currentThread().getId());
        while (countDown-->0){
            System.out.println(status());
            //在run中对静态方法Thread.yield()的调用是对线程调度起
            // (java线程机制的一部分,可以将CPU从一个线程转移给另外一个线程)的一种建议.
            Thread.yield();
        }
    }
}
