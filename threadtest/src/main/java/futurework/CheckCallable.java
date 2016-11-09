package futurework;

import threadtest.CheckCallBackService;
import threadtest.WorkCallBackService;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author WanChuanLai
 * @create 8/19/16.
 */
public class CheckCallable {


    final Map<String, Future<Object>> futures;
    ExecutorService executors;
    public static Object objectLock = new Object();
    CheckCallBackService check;

    public CheckCallable(CheckCallBackService check) {
        this.check = check;
        futures = new ConcurrentHashMap<String, Future<Object>>();
        executors = Executors.newCachedThreadPool();
    }

    boolean isContinue = true;

    /**
     * 作用:需要并行执行的任务
     * @param objects
     * @param <T>
     * @return
     */
    <T extends WorkService> Object execute(final T... objects) {
        for (int i = 0; i < objects.length; i++) {
            final int j = i;
            Future<Object> future = executors.submit(new Callable<Object>() {
                public Object call() throws Exception {
                    boolean result = objects[j].workrun();
                    backService.callBack(result, 0,  j + "", j + "");
                    return result;
                }
            });
            futures.put(i + "", future);

        }


        return null;
    }

    WorkCallBackService backService = new WorkCallBackService() {
        public void callBack(boolean isSuccess, int errorCode, Object... objects) {

            if(!isContinue){
                return;
            }
            // synchronized (objectLock) {
            if (isSuccess) {
                System.out.println("isSuccessA=" + isSuccess+"=object="+objects[0].toString());
                futures.remove(objects[0].toString());
            } else {
                isContinue = false;
                System.out.println("isSuccessB=" + isSuccess);
                Iterator<String> iterator = futures.keySet().iterator();
                while (iterator.hasNext()) {
                    Future<Object> future = futures.get(iterator.next());
                    future.cancel(true);
                }
                System.out.println("cancel");
                futures.clear();

            }

            if (futures.isEmpty() || futures.size() == 0) {

                System.out.println("我终于完成了");
                if (check != null) {

                    check.callBack(isContinue, 0, "成功了");
                    executors.shutdown();
                    //check=null;
                }
                // executors.shutdown();
            }
            // }
        }
    };
}
