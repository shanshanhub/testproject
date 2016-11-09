package saga;

import org.axonframework.domain.GenericEventMessage;
import org.axonframework.eventhandling.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import saga.event.AddAggregateEvent;
import saga.event.AddCacheEvent;
import saga.event.AddDbEvent;

import java.util.UUID;

/**
 * @author WanChuanLai
 * @create 9/12/16.
 */

public class OrderManagement {
    @Autowired
    EventBus eventBus;

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("saga.xml");
        EventBus eventBus = applicationContext.getBean(EventBus.class);


//        for (int i=0;i<10;i++) {
//            String itemId = UUID.randomUUID().toString();
//            test(i+" ",eventBus);
//        }

        String itemId = UUID.randomUUID().toString();
        test( itemId,eventBus);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test(String itemId,EventBus eventBus){
        System.out.println("aggregateId="+itemId);

        eventBus.publish(GenericEventMessage.asEventMessage(new AddAggregateEvent(itemId,null)));

        eventBus.publish(GenericEventMessage.asEventMessage(new AddDbEvent(itemId,null)));

        eventBus.publish(GenericEventMessage.asEventMessage(new AddCacheEvent(itemId,null)));
    }

//    public void addAggregate(){
//        eventBus.publish( GenericEventMessage.asEventMessage(new AddAggregateEvent()));
//    }

}
