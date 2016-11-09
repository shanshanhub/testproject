package axon.model;

import axon.command.CreateToDoItemCommand;
import axon.command.MarkCompletedCommand;
import axon.event.ToDoItemCompletedEvent;
import axon.event.ToDoItemCreatedEvent;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

/**
 * @author WanChuanLai
 * @create 7/26/16.
 */
public class ToDoItem extends AbstractAnnotatedAggregateRoot {
    @AggregateIdentifier
    private String id;

    public ToDoItem() {
    }

    @CommandHandler
    public ToDoItem(CreateToDoItemCommand command) {
        this.id = command.getTodoId();
        System.out.println("到commandhandler");
        apply(new ToDoItemCreatedEvent(command.getTodoId(), command.getDescription()));
        System.out.println("我到最后了哦");
    }


    @CommandHandler
    public void markCompleted(MarkCompletedCommand command) {
        System.out.println("222-come ToDoItem markCompleted");
        apply(new ToDoItemCompletedEvent(id));
    }

    @EventSourcingHandler
    public void sourcingHandle(ToDoItemCreatedEvent event){

        System.out.println("到eventSource这来了");
    }




//    @EventHandler
//    public void handle(ToDoItemCreatedEvent event) {
//        System.out.println("444-come ToDoItemCreatedEvent handle");
//        //完成对数据库的更新操作
//        System.out.println("We've got something to do: " + event.getDescription() + " (" + event.getTodoId() + ")");
//    }
//


//    @EventHandler
//    public void handle(ToDoItemCompletedEvent event) {
//        System.out.println("444-come ToDoItemCompletedEvent handle");
//        //完成对数据库的更新操作
//        System.out.println("We've completed a task: " + event.getTodoId());
//    }
}
