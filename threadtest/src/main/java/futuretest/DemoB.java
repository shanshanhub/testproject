package futuretest;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author WanChuanLai
 * @create 8/19/16.
 */
public class DemoB {

    public static void show() {

    }

    static final CountDownLatch latch = new CountDownLatch(3);
    boolean isContinue = true;

    public static void main(String[] args) {
        DemoB demoA = new DemoB();
        boolean isContinue = demoA.createOrder();
        System.out.println("isContinue=" + isContinue);
    }

    private static int count = 1;
    Set<Future<Object>> futures = new HashSet<Future<Object>>();
    long begin = 0L;

    public void cancelAll(){
        while (futures.iterator().hasNext()){
            Future<Object> future=futures.iterator().next();
            future.cancel(true);
            futures.remove(future);
        }
    }

    public boolean createOrder() {

        //TODO 设置固定线程数
      //  final ListIterator<Future<Object>> listIterator = futures.listIterator();
        final ExecutorService executors = Executors.newCachedThreadPool();
        begin = System.currentTimeMillis();

        WorkThreadB b = new WorkThreadB("startB", latch, false,null);
         WorkThreadA a = new WorkThreadA("startA", latch, false,null);

        WorkThreadC c = new WorkThreadC("startC", latch, false,null);
        futures.add(executors.submit(a));
        futures.add(executors.submit(b));
        futures.add(executors.submit(c));
        //executors.



        executors.execute(new Runnable() {
            public void run() {
                System.out.println("AAAAAAAAAAAAAAA");
               // while (count > 0) {

                    while (futures.iterator().hasNext()){
                        if (futures.iterator().next().isDone()) {
                            System.out.println("到这里来了");
                            Object object = null;
                            Future<Object> future=futures.iterator().next();
                            try {
                                object =future.get();
                                System.out.println("object="+object);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                            futures.remove(future);
                            if(object==null||object.toString().equals("Bfalse")){
                                cancelAll();
                                System.out.println("由Bfalse了");
                            }
                            //count--;
                            //System.out.println("count="+count);
                        }
                    }

                   // if (count <= 0) {

                        System.out.println("所有的完成了");
                        long end = System.currentTimeMillis();
                        System.out.println("end-begin=" + (end - begin));
                        executors.shutdown();
                    //}
               // }

              //  System.out.println("BBBBBBBBBB");



            }
        });


        return isContinue;
    }
}
