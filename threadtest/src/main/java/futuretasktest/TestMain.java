package futuretasktest;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public class TestMain {
    private static Map<String,FutureTask<Object>> futureTaskMap=new ConcurrentHashMap<String, FutureTask<Object>>();
    private static  final  ExecutorService executorService= Executors.newFixedThreadPool(3);

    public void addTask(Callable<Object> task,String taskName){
        FutureTask<Object> futureTask=new FutureTask<Object>(task);
        futureTaskMap.put(taskName,futureTask);
        executorService.execute(futureTask);
    }
//    public boolean taskIsDone(String key){
//        FutureTask<Object> futureTask = futureTaskMap.get(key);
//        if (futureTask != null) {
//            return futureTask.isDone();
//        }
//        return false;
//    }
//    public Object getTaskResult(String key) {
//        FutureTask<Object> futureTask = futureTaskMap.get(key);
//
//        if (futureTask.isDone()) {
//            try {
//                Object result = futureTask.get();
//                return result;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                return null;
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }
//
    public static void cancelTask(String key) {

        FutureTask<Object> futureTask = futureTaskMap.get(key);
        futureTask.cancel(true);
    }
//
    public static void cancelAllTask(){
        for (Map.Entry<String, FutureTask<Object>> iterator:futureTaskMap.entrySet()){
            cancelTask(iterator.getKey());
        }
    }


    private static boolean isRun=true;

    public static int count=1;

    public static void main(String [] args){
        long begin = System.currentTimeMillis();
        TestMain testMain=new TestMain();
        testMain.addTask(new WorkThreadA("startA",null,false),"workA");
       // testMain.addTask(new WorkThreadA("startB",null,false),"workB");
        //testMain.addTask(new WorkThreadA("startB",null,false),"workB");

        boolean isContinue=true;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, FutureTask<Object>> iterator:futureTaskMap.entrySet()){
            if( iterator.getValue().isDone()){
                count--;
                Object object=null;
                try {
                    object= iterator.getValue().get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                System.out.println(object);
                //                if(object==null||object.toString().equals("Bfalse")){
                //                    cancelAllTask();
                //                }

            }
        }
        System.out.println("isContinue="+isContinue);

//        long end = System.currentTimeMillis();
//        System.out.println("end-begin="+(end-begin)+"isContinue="+isContinue);
//
//        testMain.executorService.execute(new Runnable() {
//            public void run() {
//                while (count>0){
//                    System.out.println("count="+count);
//                    for (Map.Entry<String, FutureTask<Object>> iterator:futureTaskMap.entrySet()){
//                        if( iterator.getValue().isDone()){
//                            count--;
//                            Object object=null;
//                            try {
//                                object= iterator.getValue().get();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            } catch (ExecutionException e) {
//                                e.printStackTrace();
//                            }
//                            System.out.println(object);
//            //                if(object==null||object.toString().equals("Bfalse")){
//            //                    cancelAllTask();
//            //                }
//
//                        }
//                    }
//                }
//            }
//        });
        executorService.shutdown();

        //testMain.addTask(new WorkThreadA("startB",null,false),"workB");
        //testMain.addTask(new WorkThreadA("startB",null,false),"workB");
    }




}
