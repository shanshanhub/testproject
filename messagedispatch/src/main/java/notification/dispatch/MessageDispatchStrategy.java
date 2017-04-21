package notification.dispatch;

/**
 * @author WanChuanLai
 * @create 2/6/17.
 */
public enum MessageDispatchStrategy{
    //立即发送
    IMMEDIATELY,
    //匀速-阶段发送:以几的阶梯间隔时间发多少量
    UNIFORM_STEP
    //匀速-等量发送:多长时间间隔发多少量
    //UNIFORM_AVERAGE
}