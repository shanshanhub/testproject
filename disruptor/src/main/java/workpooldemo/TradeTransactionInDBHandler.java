package workpooldemo;

import com.lmax.disruptor.WorkHandler;
import domain.TradeTransaction;

import java.util.UUID;

/**
 * @author WanChuanLai
 * @create 8/8/16.
 */
public class TradeTransactionInDBHandler implements WorkHandler<TradeTransaction> {
    public void onEvent(TradeTransaction event) throws Exception {
        event.setId(UUID.randomUUID().toString());
        System.out.println(event.toString());

    }

}
