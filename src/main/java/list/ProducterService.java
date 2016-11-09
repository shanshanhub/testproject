package list;

/**
 * @author WanChuanLai
 * @create 5/18/16.
 */

/**
 * 作用:不同队列服务的公共接口
 * 不同的服务框架只要实现这两个接口即可
 */
public interface ProducterService {
    /**
     * 获取队列链接
     * @return
     */
    Producter getConnection();

    /**
     * 作用:不同队列发送消息
     * @param topic
     * @param param 需要发送的消息参数
     * @return
     */
    JSONObject processMessage(String topic,JSONObject param);
}
