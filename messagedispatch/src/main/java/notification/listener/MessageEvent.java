package notification.listener;

import notification.domain.MessageSourceData;
import notification.domain.MessageType;

import java.util.EventObject;

/**
 * @author WanChuanLai
 * @create 2/6/17.
 * 1.3,事件对象
 */
public abstract class MessageEvent extends EventObject {

    public MessageEvent(Object source) {
        super(source);
    }

}
