package huchihuogongxiangneicun;

/**
 * @author WanChuanLai
 * @create 8/28/16.
 */
public class HelloWorld
{
    public static void main(String []args) throws InterruptedException {
        Thread myThread=new Thread(){
            public void run(){
                System.out.println("hello from new thread");
            }
        };
        myThread.start();
        //yield:表示当前线程想让出对处理器的占用
        Thread.yield();
        System.out.println("hello from main thread");
        //main线程调用join 来等待myThread线程结束
        myThread.join();

    }
}
