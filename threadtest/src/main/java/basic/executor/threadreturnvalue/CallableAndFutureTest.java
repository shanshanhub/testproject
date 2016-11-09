package basic.executor.threadreturnvalue;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 * //Runnable是执行工作的独立任务,但是它不返回值.如果你希望任务在完成时能返回值,实现Callable接口
 * 并且必须使用ExecutorService.submit()方法使用
 *
 * submit()会产生一个Future对象,它用Callable返回结果的特定类型进行了参数化
 * 可以用isDone 方法来查询Future是否已经完成
 * 也可以不用isDone,直接用get(),get()将阻塞,直到结果准备就绪.
 *
 * Future表示异步计算的结果.它提供了检查是否完成的方法,以等待结果的完成,并获取计算的结果.
 * 计算完成后只能用get方法来获取结果,如有必要,计算完成前可以堵塞此方法.
 * 取消则由cancel方法执行,将会调用interupt 方法来中断特定的任务
 *
 *
 */


public class  CallableAndFutureTest{

    public static void main(String [] args){
        ExecutorService executorService= Executors.newCachedThreadPool();
        ArrayList<Future<String>> results=new ArrayList<Future<String>>();
        for (int i=0;i<10;i++){
            results.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs:results){
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }



}
