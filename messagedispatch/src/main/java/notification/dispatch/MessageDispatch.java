package notification.dispatch;

/**
 * @author WanChuanLai
 * @create 2/6/17.
 */

import notification.domain.Message;

/**
 1，根据策略，调度消息 MessageDispatchStrategy:发送策略：立即发送、阶梯间隔发送、平均间隔发送
 1.1. 如果是立即发送，则直接调用发送接口
 1.2. 如果是阶梯发送，则Message.count/batchCount 为需要调度的消息发送数，调度的间隔时间为intervalTimeSecond的阶梯
 1.3 如果是平均间隔发送，Message.count/batchCount 为需要调用的消息发送数,调度的间隔时间为intervalTimeSecond
 2，发送消息
 对于发送的消息，考虑到发送时的性能问题，需要对一批发送的数据，再进行分批
 在配置文件中设置：发送路由策略（每个队列处理的量（又队列管理中设置），路由策略可自己定义,暂定按照数量走 ）
 2.1 如果不走队列，则按照路由建立线程数，通过多线程，直接调用第三方通道
 2.2 如果走队列，则按照路由，把消息publish 给多个队列
 3,消息结果
 3.1 如果直接发送给第三方通道消息失败，则改用备用第三方通道发
 3.2 如果传给队列，队列消费失败时，则再次调用消息处理
 **/
public interface MessageDispatch{
    //根据发送策略，调度、发送消息
   // message:发送过来组装好的消息
    //intervalTimeSecond:间隔时间，如果是阶梯策略，就是阶梯
    //batchCount:一批的发送量
    void dispatchBatch(Message message, int intervalTimeSecond, int batchCount);
    /**
     作用：单条消息发送
     message:发送过来组装好的消息
     intervalTimeSecond:间隔时间，如果是阶梯策略，就是阶梯
     dispatchCount:调度多少次
     **/
    void dispatchSingle(Message message,int intervalTimeSecond,int dispatchCount);
}
