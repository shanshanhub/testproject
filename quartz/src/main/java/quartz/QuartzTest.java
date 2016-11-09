package quartz;

import org.joda.time.DateTime;
import org.quartz.*;
import org.quartz.Calendar;
import org.quartz.impl.StdSchedulerFactory;

import java.util.*;

/**
 * @author WanChuanLai
 * @create 9/5/16.
 */
public class QuartzTest {
    public static void main(String [] args) throws SchedulerException, InterruptedException {
        // 创建 SchedulerFactory 并获取 Scheduler 对象实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        // 通过 JobBuilder 创建 JobDetail 对象实例
        JobDetail jobDetail = JobBuilder.newJob(JobTest.class)
                .withIdentity("helloJob", Scheduler.DEFAULT_GROUP)
                .build();
        // 通过 TriggerBuilder 创建 Trigger 对象实例，设置每 5 秒调度一次任务
        Date time=new Date();

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(calendar.SECOND, 60);
        System.out.println(calendar.getTime());
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("helloTrigger", Scheduler.DEFAULT_GROUP)
                .startAt(calendar.getTime())
                .build();
        // 排定任务
        scheduler.scheduleJob(jobDetail, trigger);

        // 启动调度器
        scheduler.start();
        //
        Thread.sleep(20L * 1000000L);
        // 关闭调度器
        scheduler.shutdown(true);

    }
}
