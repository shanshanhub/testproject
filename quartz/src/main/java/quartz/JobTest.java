package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author WanChuanLai
 * @create 9/5/16.
 */
public class JobTest implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("到job 这来了");
    }
}
