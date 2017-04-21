package notification.dispatch.producer;


/**
 消息队列-producer
 **/
public interface ProducerProxy{
    /**
     发送消息到第三方队列
     messageKey:业务定义的唯一消息
     channel:消息通道名称
     tag:消息标签
     message:消息 json格式
     return:返回messageID,由服务器端生成唯一id值
     **/
    String send(String messageKey,String channel,String tag,String message);
}
