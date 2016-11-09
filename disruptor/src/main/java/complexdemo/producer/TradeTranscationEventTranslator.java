package complexdemo.producer;

import com.lmax.disruptor.EventTranslator;
import domain.TradeTransaction;

import java.util.Random;

/**
 * @author WanChuanLai
 * @create 8/8/16.
 */
public class TradeTranscationEventTranslator implements EventTranslator<TradeTransaction> {
    private Random random=new Random();
    public void translateTo(TradeTransaction event, long sequence) {
        event.setPrice(random.nextDouble()*9999);

    }
}
