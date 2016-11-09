package axon;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.axonframework.commandhandling.disruptor.DisruptorCommandBus;
import org.axonframework.domain.*;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.EventListener;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventsourcing.AbstractEventSourcedAggregateRoot;
import org.axonframework.eventsourcing.EventSourcedEntity;
import org.axonframework.eventsourcing.GenericAggregateFactory;
import org.axonframework.eventstore.EventStore;
import org.axonframework.repository.Repository;
import org.axonframework.unitofwork.UnitOfWork;

import java.io.File;
import java.util.*;
import java.util.concurrent.CountDownLatch;

//import static org.junit.Assert.*;

/**
 * @author WanChuanLai
 * @create 8/17/16.
 */
public class TestDisruptorCommandBus {
    private static final int COMMAND_COUNT = 2;

    private static final Map<String, DomainEventMessage> storedEvents = new HashMap<String, DomainEventMessage>();

    public static void main(String[] args) throws InterruptedException {


        //定义事件总线
        CountingEventBus eventBus = new CountingEventBus();
        //存储在map 中
        InMemoryEventStore eventStore = new InMemoryEventStore();


        //命令处理程序
        StubHandler stubHandler = new StubHandler();
        //命令处理总线
        DisruptorCommandBus commandBus = new DisruptorCommandBus(eventStore, eventBus);
        //命令总线订阅命令
        commandBus.subscribe(StubCommand.class.getName(), stubHandler);

        stubHandler.setRepository(commandBus.createRepository(new GenericAggregateFactory<StubAggregate>(StubAggregate.class)));

        final String aggregateIdentifier = "MyID";

        long start = System.currentTimeMillis();
        for (int i = 0; i < COMMAND_COUNT; i++) {
            //发布命令
            CommandMessage<StubCommand> stubCommandCommandMessage = new GenericCommandMessage<StubCommand>(new StubCommand(aggregateIdentifier));
            commandBus.dispatch(stubCommandCommandMessage);
            System.out.println(i);
        }

        //eventStore.countDownLatch.await(1, TimeUnit.SECONDS);
        long end = System.currentTimeMillis();

       // assertEquals("还没有发布的事件", 0, eventBus.publisherCountDown.getCount());
        //assertEquals("还没有存储的事件", 0, eventStore.countDownLatch.getCount());
        commandBus.stop();

        System.out.println("总用时 " + ((COMMAND_COUNT * 1000L) / (end - start)));
        System.out.println(storedEvents);

    }

    private static class InMemoryEventStore implements EventStore {


        private final CountDownLatch countDownLatch = new CountDownLatch((int) (COMMAND_COUNT + 1L));

        public void appendEvents(String type, DomainEventStream events) {
            System.out.println("isisiis=" + type);
            if (!events.hasNext()) {
                return;
            }
            String key = events.peek().getAggregateIdentifier().toString();
            DomainEventMessage<?> lastEvent = null;
            while (events.hasNext()) {
                 countDownLatch.countDown();
                lastEvent = events.next();
            }
            System.out.println("lastEvent="+lastEvent);
            storedEvents.put(key, lastEvent);
        }


        public DomainEventStream readEvents(String type, Object identifier) {
            DomainEventMessage stream = storedEvents.get(identifier.toString());
            return new SimpleDomainEventStream(stream);
        }
    }


    private static class StubCommand {

        @TargetAggregateIdentifier
        private Object aggregateIdentifier;

        public StubCommand(Object aggregateIdentifier) {
            this.aggregateIdentifier = aggregateIdentifier;
        }

        public Object getAggregateIdentifier() {
            return aggregateIdentifier;
        }
    }


    private static class StubAggregate extends AbstractEventSourcedAggregateRoot {

        private String identifier;


        public Object getIdentifier() {
            return identifier;
        }

        public void doSomething() {
            String uuid = UUID.randomUUID().toString();
            System.out.println("do comand handler:" + uuid);
            apply(new StubDomainEvent(uuid));
        }

        @Override
        protected void handle(DomainEventMessage event) {
            identifier = (String) event.getAggregateIdentifier();
        }

        @Override
        protected Collection<EventSourcedEntity> getChildEntities() {
            return Collections.emptyList();
        }
    }

    private static class StubHandler implements CommandHandler<StubCommand> {

        private Repository<StubAggregate> repository;

        private StubHandler() {
        }


        public Object handle(CommandMessage<StubCommand> command, UnitOfWork unitOfWork) throws Throwable {

            StubAggregate aggregate = null;
            try {
                aggregate = repository.load(command.getPayload().getAggregateIdentifier());
            } catch (Exception ex) {
                System.out.println("ex:" + ex);
            }
            if (aggregate == null) {
                aggregate = new StubAggregate();
                aggregate.identifier = "MyID";
                repository.add(aggregate);
            }

            if (aggregate != null) {
                aggregate.doSomething();
            }
            return null;
        }

        public void setRepository(Repository<StubAggregate> repository) {
            this.repository = repository;
        }
    }

    private static class StubDomainEvent {
        public StubDomainEvent(String uuid) {
            System.out.println("do Event:" + uuid);
        }
    }


    private static class CountingEventBus implements EventBus {

        private final CountDownLatch publisherCountDown = new CountDownLatch(COMMAND_COUNT);


        public void publish(EventMessage... events) {

            publisherCountDown.countDown();
        }


        public void subscribe(EventListener eventListener) {
            throw new UnsupportedOperationException("Not implemented yet");
        }


        public void unsubscribe(EventListener eventListener) {
            throw new UnsupportedOperationException("Not implemented yet");
        }
    }


}
