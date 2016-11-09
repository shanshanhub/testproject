package saga;

import org.axonframework.saga.annotation.AbstractAnnotatedSaga;
import org.axonframework.saga.annotation.SagaEventHandler;
import org.axonframework.saga.annotation.StartSaga;
import saga.event.AddAggregateEvent;
import saga.event.AddCacheEvent;
import saga.event.AddDbEvent;


/**
 * @author WanChuanLai
 * @create 9/12/16.
 */
public class OrderManagementSaga extends AbstractAnnotatedSaga {
    private boolean paid = false;
    private boolean delivered = false;

    @StartSaga
    @SagaEventHandler(associationProperty = "sagaId")
    public void handle(AddAggregateEvent event) {
        System.out.println("start AddAggregateEvent "+event.getSagaId());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("started AddAggregateEvent "+event.getSagaId());
    }

    @SagaEventHandler(associationProperty = "sagaId")
    public void handle(AddCacheEvent event) {
        System.out.println("start AddCacheEvent "+event.getSagaId());
//        try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("started AddCacheEvent "+event.getSagaId());
    }

    @SagaEventHandler(associationProperty = "sagaId")
    public void handle(AddDbEvent event) {
        System.out.println("start AddDbEvent "+event.getSagaId());
//        try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("started AddDbEvent "+event.getSagaId());
    }
}
