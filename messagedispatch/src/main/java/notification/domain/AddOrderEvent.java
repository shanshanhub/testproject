package notification.domain;

import notification.listener.MessageEvent;

/**
 * @author WanChuanLai
 * @create 2/7/17.
 */
public class AddOrderEvent extends MessageEvent {
    public AddOrderEvent(Object source) {
        super(source);
    }
}
