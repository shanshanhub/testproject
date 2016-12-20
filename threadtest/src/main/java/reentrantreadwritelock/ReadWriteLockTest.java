package reentrantreadwritelock;

import java.util.Random;

/**
 * @author WanChuanLai
 * @create 12/20/16.
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        final QueueTest q3 = new QueueTest();
        for (int i = 0; i < 3; i++) {
            new Thread() {
                public void run() {
                    while (true) {
                        q3.get();
                    }
                }

            }.start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread() {
                public void run() {
                    while (true) {
                        q3.put(new Random().nextInt(10000));
                    }
                }

            }.start();
        }

    }
}
