package complexdemo;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;
import complexdemo.consumer.TradeTransactionJMSNotifyHandler;
import complexdemo.consumer.TradeTransactionVasConsumer;
import complexdemo.producer.TradeTransactionPublisher;
import domain.TradeTransaction;
import simpledemo.TradeTransactionInDBHandler;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WanChuanLai
 * @create 8/8/16.
 * 实现:
 * 从中图可以看出需求是介样子的：生产者生产数据经过C1,C2处理完成后再到C3。
假设如下场景：
1、交易网关收到交易(P1)把交易数据发到RingBuffer中，
2、负责处理增值业务的消费者C1和负责数据存储的消费者C2负责处理交易
3、负责发送JMS消息的消费者C3在C1和C2处理完成后再进行处理。
 */
public class demo {
    public static void main(String [] args) throws InterruptedException {
        long beginTime = System.currentTimeMillis();

        int bufferSize = 1024;

        ExecutorService executorService= Executors.newFixedThreadPool(4);

        Disruptor<TradeTransaction> disruptor=new Disruptor<TradeTransaction>(new EventFactory<TradeTransaction>() {
            public TradeTransaction newInstance() {
                return new TradeTransaction();
            }
        },bufferSize,executorService, ProducerType.SINGLE,new BusySpinWaitStrategy());

        EventHandlerGroup<TradeTransaction> handlerGroup=disruptor.handleEventsWith(new TradeTransactionVasConsumer(),new TradeTransactionInDBHandler());

        TradeTransactionJMSNotifyHandler tradeTransactionJMSNotifyHandler=new TradeTransactionJMSNotifyHandler();

        //申明C1,C2走完后,走C3
        handlerGroup.then(tradeTransactionJMSNotifyHandler);
        disruptor.start();

        CountDownLatch latch=new CountDownLatch(1);
        executorService.submit(new TradeTransactionPublisher(disruptor,latch));
        latch.await();//等生产者完事
        disruptor.shutdown();
        executorService.shutdown();

        System.out.println("总耗时:"+(System.currentTimeMillis()-beginTime));



    }
}
