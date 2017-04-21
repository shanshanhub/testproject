package notification.dispatch.push;

import notification.domain.Message;

/**
 直接push到第三方
 **/
public class MessagePush implements MessagePushProxy{
    public boolean push(Message message) {
        return false;
    }
}
