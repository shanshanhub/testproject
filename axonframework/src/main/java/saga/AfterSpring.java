package saga;

import org.axonframework.domain.EventMessage;
import org.axonframework.eventhandling.Cluster;
import org.axonframework.eventhandling.EventProcessingMonitor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;

/**
 * @author WanChuanLai
 * @create 9/17/16.
 */
public class AfterSpring implements ApplicationListener<ContextRefreshedEvent> {
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Cluster cluster= (Cluster) event.getApplicationContext().getBean("simple");
        cluster.subscribeEventProcessingMonitor(new EventProcessingMonitor() {
            public void onEventProcessingCompleted(List<? extends EventMessage> eventMessages) {
                System.out.println("here onEventProcessingCompleted"+eventMessages.get(0).getPayloadType().getSimpleName());
            }

            public void onEventProcessingFailed(List<? extends EventMessage> eventMessages, Throwable cause) {
                System.out.println("here onEventProcessingFailed"+eventMessages.size());
            }
        });
    }
}
