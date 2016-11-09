package ObservableQueue;

/**
 * @author WanChuanLai
 * @create 6/17/16.
 */
public class TestWatcher {
    public static void main(String[] args) {
        QueueWatched beingWatched = new QueueWatched();//受查者
        QueueWatcher watcher = new QueueWatcher();//观察者
        beingWatched.addObserver(watcher);
        beingWatched.push("哈哈哈哈");

        beingWatched.push("yyyyy");
    }
}
