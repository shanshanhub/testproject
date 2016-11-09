package basic;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public class MainTest {
    public static void main(String [] args){

        RunnableTest runnableTest=new RunnableTest();
        //1,这个地方的Run不是由单独的线程驱动的
        //1------------
//        runnableTest.run();
        //1--------------


        //2,要实现Runnable的任务,你必须显示的将一个任务附到一个线程上
        //将Runnable转换为工作任务的传统方式是把它交给一个Thread构造器.
        //展示如何使用Thread来驱动RunnableTest对象
        //2-----------
//        Thread thread=new Thread(runnableTest);
//        thread.start();
//        System.out.println("wait for runable");
        //2-------------
        //2.1 添加更多的线程去驱动任务
        //2.1-----------
        for (int i=0;i<5;i++){
            new Thread(new RunnableTest()).start();
        }
        //2.1-----------


        //3,执行器(Executor),将管理你的Thread对象.
        //Executor在客户端和任务执行之间提供了一个间接层
        //Executor 允许你管理异步任务的执行,而无须显示的管理线程的生命周期
        //ExecutorService(具有服务生命周期的Executor)知道如何构件恰当的上来文来执行Runnable对象
        //ExecutorService是使用静态的Executor创建的,这个方法可以确定Executor的类型
        //当个的Executor被用来创建和管理系统中所有的任务
        //shutDown()方法的调用可以防止新的任务被提交给Executor

        //4 从任务中产生返回值
        //Runnable是执行工作的独立任务,但是它不返回值.如果你希望任务在完成时能返回值,
        //实现Callable接口
    }
}
