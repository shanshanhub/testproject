package ObservableQueue;

/**
 * @author WanChuanLai
 * @create 6/17/16.
 */
public class QueueWatcher implements java.util.Observer  {
    public void update(java.util.Observable obj, Object arg) {
        System.out.println("Update() called, count is "
                + ((String) arg));
    }
}
