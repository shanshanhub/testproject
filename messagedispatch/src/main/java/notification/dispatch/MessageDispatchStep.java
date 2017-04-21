package notification.dispatch;

import notification.domain.Message;

/**
 阶梯调度
 **/
public class MessageDispatchStep implements MessageDispatch {
    public void dispatchBatch(Message message, int intervalTimeSecond, int batchCount) {

    }

    public void dispatchSingle(Message message, int intervalTimeSecond, int dispatchCount) {

    }
}
