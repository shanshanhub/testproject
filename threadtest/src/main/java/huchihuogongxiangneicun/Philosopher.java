package huchihuogongxiangneicun;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WanChuanLai
 * @create 8/28/16.
 * ReentrantLock 可以为获取锁的操作设置超时时间
 */
public class Philosopher extends Thread{
    private ReentrantLock leftChopstick,rightChopstick;
    private Random random;
    public void run(){
        try {
            while (true){
                Thread.sleep(random.nextInt(1000));//思考一段时间
                leftChopstick.lock();
                try{
                    if(rightChopstick.tryLock(1000, TimeUnit.MICROSECONDS)){
                        //获取右手边的筷子
                        try{
                            Thread.sleep(random.nextInt(1000));//进餐一段时间
                        }finally {
                            rightChopstick.unlock();
                        }
                    }else{
                        //没有获取到右手边的筷子,放弃并并继续思考
                    }
                }finally {
                    leftChopstick.unlock();
                }
            }
        }catch (InterruptedException e){

        }
    }
}
