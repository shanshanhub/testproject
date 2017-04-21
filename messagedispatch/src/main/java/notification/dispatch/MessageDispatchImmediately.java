package notification.dispatch;

import notification.domain.Message;

/**
 立即调度
 **/
public class MessageDispatchImmediately implements MessageDispatch{

    public void dispatchBatch(Message message, int intervalTimeSecond, int batchCount) {

    }
    public void dispatchSingle(Message message, int intervalTimeSecond, int dispatchCount) {

    }
}