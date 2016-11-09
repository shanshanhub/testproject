package huchihuogongxiangneicun;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WanChuanLai
 * @create 8/29/16.
 * <p>
 * 作用:条件变量
 * 一个条件变量需要与一把锁关联,线程在开始等待条件之前必须获取这把锁.
 * 获取锁后,线程检查所有的条件是否为真,如果条件为真,线程将继续执行并解锁
 * <p>
 * 如果所等待的条件不为真,线程会调用await(),它将原子的解锁并堵塞等待改条件.
 * 当另外一个线程调用了signal()或者signalAll(),
 * 意味着对应的条件可能变为真.await()讲原子的恢复运行并重新加锁
 * 意味着对应的条件可能为false,将执行下面的逻辑,并解锁
 * <p>
 * 优化 哲学家进餐的问题
 */

public class PhilosopherTwo extends Thread {
    private boolean eating;
    private PhilosopherTwo left;
    private PhilosopherTwo right;
    private ReentrantLock table;
    private Condition condition;
    private Random random;

    public PhilosopherTwo(ReentrantLock table) {
        eating = false;
        this.table = table;
        condition = this.table.newCondition();
        random = new Random();
    }

    public void setLeft(PhilosopherTwo left) {
        this.left = left;
    }

    public void setRight(PhilosopherTwo right) {
        this.right = right;
    }

    private void think() throws InterruptedException {
        table.lock();
        try {
            eating = false;
            left.condition.signal();
            right.condition.signal();
        } finally {
            table.unlock();
            Thread.sleep(1000);
        }
    }

    private void eat() throws InterruptedException {
        table.lock();
        try {
            while (left.eating || right.eating) {
                condition.await();
            }
            eating = true;
        } finally {
            table.unlock();
        }
    }

    public void run() {
        try {
            try {
                think();
                eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {

        }
    }
}
