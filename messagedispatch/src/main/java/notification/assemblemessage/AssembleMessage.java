package notification.assemblemessage;


import notification.domain.Message;
import notification.domain.MessageSourceData;

import java.util.List;

/**
 * @author WanChuanLai
 * @create 2/6/17.
 * 组装消息
 */
public interface AssembleMessage {
    /**
     * 根据消息的来源组装数据
     */
    List<Message> handler(MessageSourceData sourceData);
}
