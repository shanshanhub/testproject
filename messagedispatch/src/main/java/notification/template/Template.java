package notification.template;


import notification.domain.MessageType;

import java.io.Serializable;

/**
 * @author WanChuanLai
 * @create 2/6/17.
 * 消息模版
 */
public interface Template {
    /**
     * 获取模版id
     * @return
     */
    String getId();

    Template getByMessageType(MessageType messageType);




}
