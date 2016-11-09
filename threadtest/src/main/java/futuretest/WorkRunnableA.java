package futuretest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * @author WanChuanLai
 * @create 8/23/16.
 */
public class WorkRunnableA implements Runnable{
    String work="";
    CountDownLatch finishLatch;
    boolean isStop=true;
    public WorkRunnableA(String work,CountDownLatch finishLatch,boolean isStop){
        this.work=work;
        this.finishLatch=finishLatch;
        this.isStop=isStop;
    }

    public void stop(){
        this.isStop=true;
    }

    public void run(){

        boolean result=false;
         while (!isStop){
        if(this.work.equals("startA")){
            System.out.println("A1------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A2------");

        }
        if(result){
            finishLatch.countDown();
            System.out.println("AAAAACOUNTdOWN11111");
        }else{
            for (int i=0;i<finishLatch.getCount();i++) {
                finishLatch.countDown();
                System.out.println("AAAAACOUNTdOWN2222");

            }
        }
        isStop=true;
        System.out.println("countDown="+finishLatch.getCount());
        System.out.println("子线程A" + Thread.currentThread() + "执行完毕");
        }


    }
}
