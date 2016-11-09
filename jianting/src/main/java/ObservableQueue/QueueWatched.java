package ObservableQueue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author WanChuanLai
 * @create 6/17/16.
 */
public class QueueWatched extends java.util.Observable {
    public static Queue<String> queue = new ConcurrentLinkedQueue<String>();

    void push(String message) {
        queue.add(message);
        setChanged();
        notifyObservers(queue.poll());

    }
}
