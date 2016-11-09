package complexdemo.consumer;

import com.lmax.disruptor.EventHandler;
import domain.TradeTransaction;

/**
 * @author WanChuanLai
 * @create 8/8/16.
 * 作用:事件处理器(消费者)
 * C1:负责处理增值业务的消费
 */
public class TradeTransactionVasConsumer implements EventHandler<TradeTransaction>{

    public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("come VasConsumer");
    }
}
