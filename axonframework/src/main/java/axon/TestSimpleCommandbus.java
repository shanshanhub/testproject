package axon;


import org.axonframework.commandhandling.*;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.axonframework.domain.DomainEventStream;
import org.axonframework.domain.GenericDomainEventMessage;
import org.axonframework.domain.SimpleDomainEventStream;
import org.axonframework.eventsourcing.EventSourcedEntity;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventstore.EventStore;
import org.axonframework.repository.Repository;
import org.axonframework.unitofwork.UnitOfWork;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

/**
 * @author WanChuanLai
 * @create 8/17/16.
 */
public class TestSimpleCommandbus {
    private static final UUID aggregateIdentifier = UUID.randomUUID();
    public static void main(String [] args){
        //命令总线
        CommandBus bus=new SimpleCommandBus();

        //存储在内存中
        InMemoryEventStore eventStore=new InMemoryEventStore();
        eventStore.appendInitialEvent("test",new SimpleDomainEventStream(new GenericDomainEventMessage<SomeEvent>(aggregateIdentifier,0,new SomeEvent(null))));
        final MyAggregate myAggregate=new MyAggregate(aggregateIdentifier);
        Repository<MyAggregate> repository=new Repository<MyAggregate>() {
            public MyAggregate load(Object aggregateIdentifier, Long expectedVersion) {
                throw new UnsupportedOperationException("Not implemented yet");
            }

            public MyAggregate load(Object aggregateIdentifier) {
                return myAggregate;
            }

            public void add(MyAggregate aggregate) {

                throw new UnsupportedOperationException("Not implemented yet");
            }
        };
        bus.subscribe(String.class.getName(), new MyCommandHandler(repository));

        long COMMAND_COUNT = 50;
        bus.dispatch(GenericCommandMessage.asCommandMessage("ready,"));
        long t1 = System.currentTimeMillis();
        for (int t = 0; t < COMMAND_COUNT; t++) {
            //MyCommand myCommand=new MyCommand(aggregateIdentifier);
            bus.dispatch(GenericCommandMessage.asCommandMessage("go"));
        }
        long t2 = System.currentTimeMillis();
        System.out.println("总用时:"+ ((COMMAND_COUNT * 1000) / (t2 - t1)));

    }
    public static class MyAggregate extends AbstractAnnotatedAggregateRoot<UUID>{
        private final UUID identifier;

        protected MyAggregate() {

            this(UUID.randomUUID());
        }

        protected MyAggregate(UUID identifier) {
            this.identifier = identifier;
        }

        @Override
        public UUID getIdentifier() {
            return identifier;
        }

        public void doSomething() {
            String uuid = UUID.randomUUID().toString();
            System.out.println("do comand :"+uuid);

            apply(new SomeEvent(uuid));
        }

        @Override
        protected Collection<EventSourcedEntity> getChildEntities() {
            return Collections.emptyList();
        }
    }
    private static class SomeEvent {
        public SomeEvent(String uuid) {
            System.out.println("do Event:"+uuid);
        }
    }

    public static class MyCommandHandler implements CommandHandler<MyCommand> {

        private  Repository<MyAggregate> repository;

        public MyCommandHandler(Repository<MyAggregate>  repository){
            this.repository=repository;
        }


        public Object handle(CommandMessage<MyCommand> commandMessage, UnitOfWork unitOfWork) throws Throwable {
            this.repository.load(aggregateIdentifier).doSomething();
            return null;
        }
    }

    public static class MyCommand{
        @TargetAggregateIdentifier
        private Object aggregateIdentifier;

        public MyCommand(Object aggregateIdentifier) {
            this.aggregateIdentifier = aggregateIdentifier;
        }

        public Object getAggregateIdentifier() {
            return aggregateIdentifier;
        }
    }


    private static class InMemoryEventStore implements EventStore {

        private  DomainEventStream storedEvents;

        public void appendInitialEvent(String type, DomainEventStream events) {
            storedEvents = events;
        }
        public void appendEvents(String type, DomainEventStream events) {

        }

        public DomainEventStream readEvents(String type, Object identifier) {
            System.out.println(".");
            return storedEvents;
        }
    }


}
