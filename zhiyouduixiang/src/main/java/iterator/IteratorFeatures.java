package iterator;

import java.util.*;

/**
 * @author WanChuanLai
 * @create 6/21/16.
 * 作用:迭代器说明
 * 1,迭代器是一种设计模式
 * 2,迭代器是一个对象,他的工作是遍历并选择序列中的对象,通常被称为(轻量级对象:创建它的代价小)
 * 3,迭代器的限制:
 *   --java 的Iterator只能单向移动
 *   --用hasNext()判断是否存在
 *   --用next()来取值
 * 4,如果你不想关注你的容器类型来操作,我们可以用Iterator 对象
 */
public class IteratorFeatures {
    public static void main(String [] args){
        List<Integer> arrayList=Arrays.asList(1,2,3);
        LinkedList<Integer> linkedList=new LinkedList<Integer>(arrayList);
        HashSet<Integer> hashSet=new HashSet<Integer>(arrayList);
        TreeSet<Integer> treeSet=new TreeSet<Integer>(arrayList);
        display(linkedList.iterator());
        display(hashSet.iterator());
        display(treeSet.iterator());
    }

    public static void display(Iterator<Integer> iterator){
        while (iterator.hasNext()){
            Integer integer=iterator.next();
            System.out.println(integer);
        }

    }

}
