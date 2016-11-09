package simpledemo;

import com.lmax.disruptor.*;
import domain.TradeTransaction;

import java.util.concurrent.*;

/**
 * @author WanChuanLai
 * @create 8/8/16.
 */
public class demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final int buffer_size = 1024;
        final int thread_numbers = 2;

        /**
         * createSingleProducer创建一个单生产者的RingBuffer
         * 第一个参数EventFactory ,事件工厂,其实它的职责就是产生数据填充RingBuffer的区块
         * 第二个参数RingBuffer的大小,它必须是2的指数倍,目的是为了将其运算转为&运算提高效率
         * 第三个参数RingBuffer的生产都在没有可用区块(slot)的时候(可能是消费者(或者是事件处理器))的等待策略
         */

        final RingBuffer<TradeTransaction> ringBuffer=RingBuffer.createSingleProducer(new EventFactory<TradeTransaction>() {
            public TradeTransaction newInstance() {
                return new TradeTransaction();
            }
        },buffer_size,new YieldingWaitStrategy());

        //创建线程池
        ExecutorService executorService= Executors.newFixedThreadPool(thread_numbers);

        //创建sequenceBarrier 序号屏障器
        SequenceBarrier sequenceBarrier=ringBuffer.newBarrier();

        //创建消息处理
        BatchEventProcessor<TradeTransaction> transactionBatchEventProcessor=
                new BatchEventProcessor<TradeTransaction>(ringBuffer,sequenceBarrier,new TradeTransactionInDBHandler());

        //ringBuffer可以知晓消费者的状态
        ringBuffer.addGatingSequences(transactionBatchEventProcessor.getSequence());

        executorService.submit(transactionBatchEventProcessor);

        Future<?> future=executorService.submit(new Callable<Void>() {
           public Void call() throws Exception{
                Long seq;
               for(int i=0;i<1000;i++){
                   seq=ringBuffer.next();
                   ringBuffer.get(seq).setPrice(Math.random()*9999);
                   ringBuffer.publish(seq);//发布这个slot的数据使Handler(cousumer)可见
               }
               return null;
           }
        });

        future.get();
        Thread.sleep(1000);
        transactionBatchEventProcessor.halt();
        executorService.shutdown();



    }
}
