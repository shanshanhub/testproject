package list;

/**
 * @author WanChuanLai
 * @create 5/18/16.
 */

/**
 * 对外部接口的提供
 */
public interface MessageService {
    /**
     *作用:发送消息
     * @param topic 消息topic, 比如 message，mail
     * @param param JSONObject param={
                    "content":"{send content 比如发邮件的内容}",
                    "messagekey":"自己生成的key，供发送端消息查找"
                    }
     * @return JSONObject={
                "messageid":"生成了唯一消息的标志",
                "msg":{"msg_code":"0000","msg":"消息发送成功"}
                }

     */
    JSONObject send(String topic,JSONObject param);

    /**
     * 从cs_message_log分页获取消息
     * 前台,可以查看消息的状态
     * 前台,可以根据消息的状态重新出发消息,比如失败的消息,可以再次处理
     * 暂时可以只实现这些,删除消息,重置消息可以放到后面
     * 根据状态/时间 获取消息
     * @param message
     * @return
     */
    JSONObject getAll(Message message);

    /**
     * 作用:根据消息id 获取消息
     * @param messageId
     * @return
     */
    JSONObject getByMessageId(Long messageId);

    /**
     * 调用者自己传的messagekey
     * @param messagekey
     * @return
     */
    JSONObject getByMessagekey(String messagekey);

}
