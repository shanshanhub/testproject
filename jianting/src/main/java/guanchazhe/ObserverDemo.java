package guanchazhe;

/**
 * @author WanChuanLai
 * @create 6/17/16.
 */
public class ObserverDemo {
    public static void main(String[] args) {
        BeingWatched beingWatched = new BeingWatched();//受查者
        Watcher watcher = new Watcher();//观察者
        beingWatched.addObserver(watcher);
        beingWatched.counter(10);
    }
}

