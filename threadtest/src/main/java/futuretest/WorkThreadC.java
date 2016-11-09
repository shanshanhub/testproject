package futuretest;

import threadtest.WorkCallBackService;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author WanChuanLai
 * @create 8/19/16.
 */
public class WorkThreadC implements Callable<Object> {
    String work = "";
    CountDownLatch finishLatch;
    boolean isStop = true;

    WorkCallBackService workCallBackService;

    public WorkThreadC(String work, CountDownLatch finishLatch, boolean isStop,WorkCallBackService workCallBackService) {
        this.work = work;
        this.finishLatch = finishLatch;
        this.isStop = isStop;
        this.workCallBackService=workCallBackService;
    }

    public void stop() {
        Thread.interrupted();
        //  this.isStop=true;
    }

    public Object call() throws Exception {
        System.out.println("C Threadid="+Thread.currentThread().getId());

        boolean result = true;
        if (this.work.equals("startC")) {
            System.out.println("c1------");
            Thread.sleep(1000);
            System.out.println("c2------");
            result = false;
        }
        if (result) {
//            finishLatch.countDown();
            System.out.println("CCCCCCOUNTdOWN11111");
            if(workCallBackService!=null){
                workCallBackService.callBack(true,0,"TreadC","");
            }
        } else {
//            while (finishLatch.getCount() > 0) {
//                System.out.println("CCCCCCOUNTdOWN2222=" + finishLatch.getCount());
//                finishLatch.countDown();
//            }
            if(workCallBackService!=null){
                workCallBackService.callBack(false,0,"TreadC","");
            }
        }
        isStop = true;
       // System.out.println("countDown=" + finishLatch.getCount());
        System.out.println("子线程C=" + Thread.currentThread().getId() + "执行完毕");

        return "C"+result;

    }
}
