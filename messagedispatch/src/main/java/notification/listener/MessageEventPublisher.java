package notification.listener;

import notification.domain.AddOrderEvent;

import java.util.HashMap;
import java.util.Map;

/**
  发布事件
 */
public class MessageEventPublisher {

    Map<String,MessageEventListener> map=new HashMap<String, MessageEventListener>();


    public void publishEvent(MessageEvent event){
        map.get(event.getClass().getName()).handler(event);
    }

    public static void main(String [] args){
        MessageEventPublisher messageEventPublisher=new MessageEventPublisher();
        messageEventPublisher.publishEvent(new AddOrderEvent("124"));
    }
}
