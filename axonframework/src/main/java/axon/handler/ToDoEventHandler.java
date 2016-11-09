package axon.handler;

import axon.event.ToDoItemCompletedEvent;
import axon.event.ToDoItemCreatedEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import org.springframework.stereotype.Component;

/**
 * @author WanChuanLai
 * @create 7/26/16.
 */
@Component
public class ToDoEventHandler {

    @EventHandler
    public void handle(ToDoItemCreatedEvent event) {
        System.out.println("到eventHandler");
        //完成对数据库的更新操作
       // System.out.println("We've got something to do: " + event.getDescription() + " (" + event.getTodoId() + ")");
    }




    @EventHandler
    public void handle(ToDoItemCompletedEvent event) {
        System.out.println("444-come ToDoItemCompletedEvent handle");
        //完成对数据库的更新操作
        System.out.println("We've completed a task: " + event.getTodoId());
    }
}
