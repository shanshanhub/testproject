package axon;

import axon.command.CreateToDoItemCommand;
import axon.command.MarkCompletedCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * @author WanChuanLai
 * @create 7/26/16.
 */
public class TestRun {


    public static void main(String[] args) {
      //testDisruptorCommandBus();
        testCommandSimpleBus();
    }

    public static void testCommandSimpleBus() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("axon.xml");
        CommandGateway commandGateway = applicationContext.getBean(CommandGateway.class);
        String itemId = UUID.randomUUID().toString();
        CreateToDoItemCommand createToDoItemCommand = new CreateToDoItemCommand(itemId, "Need to do this");
        commandGateway.send(createToDoItemCommand);
       // itemId = UUID.randomUUID().toString();
        //commandGateway.send(new MarkCompletedCommand(itemId));
    }

    public static void testDisruptorCommandBus() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("axondisruptor.xml");
        CommandGateway commandGateway = applicationContext.getBean(CommandGateway.class);
        String itemId = UUID.randomUUID().toString();
        CreateToDoItemCommand createToDoItemCommand = new CreateToDoItemCommand(itemId, "Need to do this");
        commandGateway.send(createToDoItemCommand);
       // itemId = UUID.randomUUID().toString();
        commandGateway.send(new MarkCompletedCommand(itemId));
    }

}
