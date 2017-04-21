package notification.dispatch.push;

import notification.domain.Message;

/**
 * 通过到消息队列
 */
public class MessageQueuePush implements MessagePushProxy {
    public boolean push(Message message) {
        return false;
    }
}
