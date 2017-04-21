package notification.listener;

import notification.domain.AddOrderEvent;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author WanChuanLai
 * @create 2/7/17.
 * 创建订单事件
 * 也可以自己定义一个Listener,设置对应的要处理的Event
 */
public class AddOrderEventListener extends AbstractEventListener<AddOrderEvent> {

    public void handler(AddOrderEvent event) {

    }
}
