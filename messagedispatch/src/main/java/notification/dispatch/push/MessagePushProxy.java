package notification.dispatch.push;

import notification.domain.Message;

/**
 消息推送
 1，直接推送到第三方
 2,推送到消息队列，再由消息队列推送到第三方
 **/
public interface MessagePushProxy{
    //往队列中推消息
    //1.往队列中推数据时
    boolean push(Message message);
}
