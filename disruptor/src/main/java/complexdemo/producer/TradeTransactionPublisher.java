package complexdemo.producer;

import com.lmax.disruptor.dsl.Disruptor;
import domain.TradeTransaction;

import java.util.concurrent.CountDownLatch;

/**
 * @author WanChuanLai
 * @create 8/8/16.
 */
public class TradeTransactionPublisher implements Runnable {

    Disruptor<TradeTransaction> disruptor;
    private CountDownLatch latch;
    private static int loop=10000;//模拟一千万次交易的发生
    public TradeTransactionPublisher(Disruptor<TradeTransaction> disruptor,CountDownLatch latch){
        this.disruptor=disruptor;
        this.latch=latch;
    }

    public void run() {
        TradeTranscationEventTranslator eventTranslator=new TradeTranscationEventTranslator();
        for(int i=0;i<loop;i++) {
            System.out.println("come Publisher i="+i);
            disruptor.publishEvent(eventTranslator);
        }
        latch.countDown();
    }
}
