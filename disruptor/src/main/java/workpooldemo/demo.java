package workpooldemo;

import com.lmax.disruptor.*;
import domain.TradeTransaction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author WanChuanLai
 * @create 8/8/16.
 * 使用workerpool辅助创建消费者
 */
public class demo {

    public static void main(String [] args) throws InterruptedException {
        final int buffer_size=1024;
        final int thread_numbers=4;

        EventFactory<TradeTransaction> eventFactory=new EventFactory<TradeTransaction>() {
            public TradeTransaction newInstance() {
                return new TradeTransaction();
            }
        };

        RingBuffer<TradeTransaction> ringBuffer=RingBuffer.createSingleProducer(eventFactory,buffer_size);

        SequenceBarrier sequenceBarrier=ringBuffer.newBarrier();

        ExecutorService executorService= Executors.newFixedThreadPool(thread_numbers);

        WorkHandler<TradeTransaction> [] workHandlers=new WorkHandler[3];
        for(int i=0;i<3;i++){
            WorkHandler<TradeTransaction> workHandler=new TradeTransactionInDBHandler();
            workHandlers[i]=workHandler;
        }

        WorkerPool<TradeTransaction> workerPool=new WorkerPool<TradeTransaction>(ringBuffer,sequenceBarrier,new IgnoreExceptionHandler(),workHandlers);

        workerPool.start(executorService);

        for (int i=0;i<800;i++){
            long seq=ringBuffer.next();
            ringBuffer.get(seq).setPrice(Math.random()*9999);
            ringBuffer.publish(seq);
            if (i % 10 == 0) {
                System.out.println(((ThreadPoolExecutor) executorService).getActiveCount() + "============================================");
            }
        }
        Thread.sleep(1000);
        workerPool.halt();
        Thread.sleep(1);
        executorService.shutdown();


    }
}
