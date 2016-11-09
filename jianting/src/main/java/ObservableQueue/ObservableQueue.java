package ObservableQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javafx.collections.ObservableListBase;

/**
 * @author WanChuanLai
 * @create 6/17/16.
 */
public class ObservableQueue<E>  extends ObservableListBase<E> implements Queue<E> {
    private final Queue<E> queue ;


    /**
     * Creates an ObservableQueue backed by the supplied Queue.
     * Note that manipulations of the underlying queue will not result
     * in notification to listeners.
     *
     * @param queue
     */
    public ObservableQueue(Queue<E> queue) {
        this.queue = queue ;
    }

    /**
     * Creates an ObservableQueue backed by a LinkedList.
     */
    public ObservableQueue() {
        this(new ConcurrentLinkedQueue<E>());
    }
    @Override
    public boolean add(E e) {
        beginChange() ;
        try {
            queue.add(e);
            nextAdd(queue.size()-1, queue.size());
            return true ;
        } finally {
            endChange();
        }
    }

    @Override
    public E get(int index) {
        Iterator<E> iterator = queue.iterator();
        for (int i = 0; i < index; i++) iterator.next();
        return iterator.next();
    }

    @Override
    public int size() {
        return queue.size();
    }

    public boolean offer(E e) {
        beginChange();
        boolean result = queue.offer(e);
        if (result) {
            nextAdd(queue.size()-1, queue.size());
        }
        endChange();
        return result ;
    }

    public E remove() {
        beginChange();
        try {
            E e = queue.remove();
            nextRemove(0, e);
            return e;
        } finally {
            endChange();
        }
    }

    public E poll() {
        beginChange();
        E e = queue.poll();
        if (e != null) {
            nextRemove(0, e);
        }
        endChange();
        return e ;
    }

    public E element() {
        return queue.element();
    }

    public E peek() {
        return queue.peek();
    }
}
