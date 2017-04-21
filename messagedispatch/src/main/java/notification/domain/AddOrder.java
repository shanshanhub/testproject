package notification.domain;

/**
 * @author WanChuanLai
 * @create 2/6/17.
 */
public class AddOrder implements MessageSourceData {

    public MessageType getMessageType() {
        return null;
    }

    public boolean check() {
        return false;
    }
}
