package notification.domain;

import java.util.List;

/**
 * @author WanChuanLai
 * @create 2/6/17.
 * 消息对象
 */
public class Message {
    //消息类型
    private String type;
    //消息状态为：待发送，已发送，已关闭
    private String status;
    //消息标题
    private String title;
    //消息内容
    private String content;
    //目标页
    private String targetPage;
    //推送时间
    private String pushTime;
    //发送渠道
    private String pushChannel;
    //发送人群
    private List<Member> memberList;
}
