package simpledemo;

import com.lmax.disruptor.EventHandler;
import domain.TradeTransaction;

import java.util.UUID;

/**
 * @author WanChuanLai
 * @create 8/8/16.
 */
public class TradeTransactionInDBHandler implements EventHandler<TradeTransaction> {


    public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {
        this.onEvent(event);
    }

    public void onEvent(TradeTransaction event) throws Exception{
        event.setId(UUID.randomUUID().toString());
        System.out.println(event.toString());
    }
}
