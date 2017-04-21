package notification.assemblemessage;

import notification.domain.Message;
import notification.domain.MessageSourceData;

import java.util.List;

/**
 * @author WanChuanLai
 * @create 2/6/17.
 */
public abstract class AbstractAssembleMessage implements AssembleMessage {
    public List<Message> handler(MessageSourceData sourceData) {
        List<Message> list=null;
        before(sourceData);
        process(sourceData);
        after(list);
        return null;
    }
    public void before(MessageSourceData sourceData){
        //添加日志
        //检查数据是否正确
        sourceData.check();
        //获取模版
    }

    /**
     * 子类实现各自的模版转换
     * @return
     */
    public abstract List<Message> process(MessageSourceData sourceData);

    public void after(List<Message> messages){
        //添加消息到数据库
        //添加日志
    }
}
