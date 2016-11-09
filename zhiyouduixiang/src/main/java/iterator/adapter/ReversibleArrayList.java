package iterator.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author WanChuanLai
 * @create 6/23/16.
 */
public class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c){
        super(c);
    }
    public Iterable<T> reversed(){
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current=size()-1;
                    public boolean hasNext() {
                        return current>-1;
                    }

                    public T next() {
                        return get(current--);
                    }
                };
            };
        };
    }
}
