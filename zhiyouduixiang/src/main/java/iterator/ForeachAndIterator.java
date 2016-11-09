package iterator;

import java.util.Iterator;
import java.util.Map;

/**
 * @author WanChuanLai
 * @create 6/23/16.
 * 作用:Foreach和Iterator
 * 1,foreach可以运用于任何Collection对象
 * 2,之所以能够工作,是因为javaSE5引入了新的被称为Iterable接口,该接口包含了一个能够产生Iterator的
 * Iterable()的方法,并且Iterable()接口被foreach用来在序列中移动,因此如果你创建了任何类实现了
 * Iterable 的类,都可以将它用于foreach语句中.
 * <p>
 * 3,ForeachAndIterator类中iterator()返回是实现了Iterator<Integer>()的匿名内部内
 * <p>
 * 4,java中有大量的类都是Iterable类型
 *
 * 5,foreach语法可以用于数组或者其他任何Iterable,但是并不意味着数组肯定也是一个Iterable,
 *   数组自动包装成Iterable 是不行的,必须手工执行这种转化(如:ForeachAndIterator手工转化)
 */

public class ForeachAndIterator implements Iterable<Integer> {
    protected Integer[] integers = new Integer[]{1, 2, 4, 6};


    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;

            public boolean hasNext() {
                return index < integers.length;
            }

            public Integer next() {
                return integers[index++];
            }
        };
    }

    public static void main(String[] args) {
        for (Integer interger : new ForeachAndIterator()) {
            System.out.println(interger);
        }

        //显示操作类型的系统坏境遍历
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
}
