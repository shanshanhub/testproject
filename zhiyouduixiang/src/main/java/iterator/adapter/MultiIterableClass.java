package iterator.adapter;

import iterator.ForeachAndIterator;

import java.util.*;

/**
 * @author WanChuanLai
 * @create 6/23/16.
 * 作用:在ForeachAndIterator 添加两个适配器方法
 * 1,现在对foreach 有三个适配方法
 *
 */
public class MultiIterableClass extends ForeachAndIterator {
    /**
     * 作用:倒序输出
     * @return
     */
    public Iterable<Integer> reversed() {
        return new Iterable<Integer>() {
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    int current = integers.length - 1;

                    public boolean hasNext() {
                        return current > -1;
                    }

                    public Integer next() {
                        return integers[current--];
                    }
                };
            }

            ;
        };
    }

    /**
     * 作用:返回被打算的list
     * @return
     */
    public Iterable<Integer> randomized() {
        return new Iterable<Integer>() {
            public Iterator<Integer> iterator() {
                List<Integer> suffled = new ArrayList<Integer>(Arrays.asList(integers));
                Collections.shuffle(suffled, new Random(47));
                return suffled.iterator();

            }

            ;
        };
    }

    public static void main(String[] args) {

        MultiIterableClass multiIterableClass = new MultiIterableClass();
        System.out.println("------反转输出-------------");
        for (Integer integer : multiIterableClass.reversed()) {
            System.out.println(integer);
        }
        System.out.println("------打乱顺序输出---------------");
        for (Integer integer : multiIterableClass.randomized()) {
            System.out.println(integer);
        }

        System.out.println("------正序输出------------");
        for (Integer integer:multiIterableClass){
            System.out.println(integer);
        }
    }

}
