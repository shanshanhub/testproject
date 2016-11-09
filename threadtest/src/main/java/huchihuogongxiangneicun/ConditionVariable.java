package huchihuogongxiangneicun;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WanChuanLai
 * @create 8/29/16.
 *
 * 一个条件变量需要与一把锁关联,线程在开始等待条件之前必须获取这把锁.
 * 获取锁后,线程检查所有的条件是否为真,如果条件为真,线程讲继续执行并解锁
 *
 */
public class ConditionVariable {
    ReentrantLock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    boolean result=false;
    public void test() throws InterruptedException {
        lock.lock();
        try {
            while (!result){
                condition.await();
            }


        }finally {
            lock.unlock();
        }
    }
}
