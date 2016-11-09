package complexdemo.consumer;

import com.lmax.disruptor.EventHandler;
import domain.TradeTransaction;

import java.util.UUID;

/**
 * @author WanChuanLai
 * @create 8/8/16.
 * 作用:事件处理器(消费者)
 * C2:负责数据存储的消费者
 *
 */
public class TradeTranscationInDBHandler implements EventHandler<TradeTransaction> {
    public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {
        event.setId(UUID.randomUUID().toString());
        System.out.println("come on DBHandler"+event.toString());
    }
}
