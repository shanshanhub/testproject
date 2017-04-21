package notification.assemblemessage;

import notification.domain.Message;
import notification.domain.MessageSourceData;

import java.util.List;

/**
 * @author WanChuanLai
 * @create 2/6/17.
 * 提供公共的组装数据类
 * 如果有其它不同的自行继承组装
 */
public class CommonAssembleMessage extends AbstractAssembleMessage {
    @Override
    public List<Message> process(MessageSourceData sourceData) {
        return null;
    }
}
