package huchihuogongxiangneicun;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WanChuanLai
 * @create 8/28/16.
 * ReentrantLock 提供了显示的lock和unLock方法
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        final ReentrantLock l1 = new ReentrantLock();
        final ReentrantLock l2 = new ReentrantLock();
        Thread t1 = new Thread() {

            public void run() {
                try {
                    l1.lockInterruptibly();

                    Thread.sleep(1000);
                    l2.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
    }
}