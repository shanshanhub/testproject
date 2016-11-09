package futuretest;

import threadtest.WorkCallBackService;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author WanChuanLai
 * @create 8/19/16.
 */
public class WorkThreadA implements Callable<Object> {
    String work = "";
    CountDownLatch finishLatch;
    boolean isStop = true;
    WorkCallBackService workCallBackService;

    public WorkThreadA(String work, CountDownLatch finishLatch, boolean isStop,WorkCallBackService workCallBackService) {
        this.work = work;
        this.finishLatch = finishLatch;
        this.isStop = isStop;
        this.workCallBackService=workCallBackService;
    }

    public void stop() {
        this.isStop = true;
    }

    public Object call() throws Exception {
        System.out.println("A Threadid="+Thread.currentThread().getId());
        boolean result = false;
        if (this.work.equals("startA")) {
            System.out.println("A1------");
            Thread.sleep(5000);
            System.out.println("A2------");
            result = true;

        }

        isStop = true;
      //  System.out.println("countDown=" + finishLatch.getCount());
        System.out.println("子线程A=" + Thread.currentThread().getId() + "执行完毕");
        if (result) {
//            finishLatch.countDown();
            System.out.println("AAAAACOUNTdOWN11111");
            if(workCallBackService!=null){
                workCallBackService.callBack(true,0,"TreadA","");
            }

        } else {

//            while (finishLatch.getCount() > 0) {
//                System.out.println("AAAAACOUNTdOWN2222=" + finishLatch.getCount());
//                finishLatch.countDown();
//            }
            if(workCallBackService!=null){
                workCallBackService.callBack(false,0,"TreadA","");
            }

        }
        return "A"+result;

    }
}
