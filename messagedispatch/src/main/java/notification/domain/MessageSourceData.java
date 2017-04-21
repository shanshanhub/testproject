package notification.domain;

/**
 * @author WanChuanLai
 * @create 2/6/17.
 * 作用:消息来源的业务数据
 */
public interface MessageSourceData {
    /**
     * 不同的消息来源设置消息类型
     * @return
     */
    MessageType  getMessageType();

    //检查数据是否完整
    boolean check();
}
