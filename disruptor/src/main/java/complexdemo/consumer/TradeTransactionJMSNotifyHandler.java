package complexdemo.consumer;

import com.lmax.disruptor.EventHandler;
import domain.TradeTransaction;

/**
 * @author WanChuanLai
 * @create 8/8/16.
 */
public class TradeTransactionJMSNotifyHandler implements EventHandler<TradeTransaction> {
    public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("发送JMS消息");
    }
}
