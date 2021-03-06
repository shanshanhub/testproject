package futuretest;

import threadtest.WorkCallBackService;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author WanChuanLai
 * @create 8/19/16.
 */
public class WorkThreadB implements Callable<Object> {
    String work = "";
    CountDownLatch finishLatch;
    boolean isStop = true;

    WorkCallBackService workCallBackService;

    public WorkThreadB(String work, CountDownLatch finishLatch, boolean isStop,WorkCallBackService workCallBackService) {
        this.work = work;
        this.finishLatch = finishLatch;
        this.isStop = isStop;
        this.workCallBackService=workCallBackService;
    }
    public void stop() {
        this.isStop = true;
    }

    public Object call() throws Exception {
        System.out.println("B Threadid="+Thread.currentThread().getId());
        boolean result = false;
        if (this.work.equals("startB")) {
            System.out.println("B1------");
            Thread.sleep(3000);
            System.out.println("B2------");
            result = true;
        }
        if (result) {
//            finishLatch.countDown();
            System.out.println("BBBBBCOUNTdOWN11111");
            if(workCallBackService!=null){
                workCallBackService.callBack(true,0,"TreadB","");
            }
        } else {
//            while (finishLatch.getCount() > 0) {
//                System.out.println("BBBBBCOUNTdOWN2222=" + finishLatch.getCount());
//                finishLatch.countDown();
//            }
            if(workCallBackService!=null){
                workCallBackService.callBack(false,0,"TreadB","");
            }

        }
        isStop = true;
        //System.out.println("countDown=" + finishLatch.getCount());
        System.out.println("子线程B=" + Thread.currentThread().getId() + "执行完毕");

        return "B"+result;

    }
}
