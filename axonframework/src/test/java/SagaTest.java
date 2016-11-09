import org.axonframework.domain.GenericEventMessage;
import org.axonframework.eventhandling.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.testng.annotations.Test;
//import saga.event.AddAggregateEvent;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import saga.event.AddAggregateEvent;
import saga.event.AddCacheEvent;
import saga.event.AddDbEvent;

import java.util.UUID;

/**
 * @author WanChuanLai
 * @create 9/12/16.
 */

@ContextConfiguration(locations = {"classpath:saga.xml"})
public class SagaTest extends AbstractTestNGSpringContextTests {
    @Autowired
    EventBus eventBus;

    @Test
    public void TestA(){

        System.out.println("asdfasdfasdf");
    }

    @Test(invocationCount = 10, threadPoolSize = 5)
    public void testSaga() {

        String itemId = UUID.randomUUID().toString();
        System.out.println("aggregateId="+itemId);
        eventBus.publish(GenericEventMessage.asEventMessage(new AddAggregateEvent(itemId,null)));

        eventBus.publish(GenericEventMessage.asEventMessage(new AddDbEvent(itemId,null)));

        eventBus.publish(GenericEventMessage.asEventMessage(new AddCacheEvent(itemId,null)));

    }
    @AfterClass
    public void aftertest(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
