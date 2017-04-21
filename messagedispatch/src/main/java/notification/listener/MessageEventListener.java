package notification.listener;


import java.util.EventListener;

/**
 * @author WanChuanLai
 * @create 2/6/17.
 * 1.2,事件监听
 *
 */
public interface MessageEventListener<E>  extends EventListener {
    /**
     *将这个事件源对象作为参数传给事件监听器
     *处理对应的事件
     * @param event
     */
    void handler(E event);
}
