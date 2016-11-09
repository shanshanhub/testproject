package guanchazhe;

/**
 * @author WanChuanLai
 * @create 6/17/16.
 */
public class Watcher implements java.util.Observer {
    public void update(java.util.Observable obj, Object arg) {
        System.out.println("Update() called, count is "
                + ((Integer) arg).intValue());
    }
}