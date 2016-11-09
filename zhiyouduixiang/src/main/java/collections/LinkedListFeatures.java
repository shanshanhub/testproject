package collections;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author WanChuanLai
 * @create 6/22/16.
 * 作用:LinkedList说明
 * LinkedList:
 * 1,在List的中间插入和移除 比ArrayList快
 * 2,随机访问比ArrayList慢
 * 3,添加了可以使用其作栈/队列或双端队列的方法
 * 4,LinkedList
 * 5,继承了Queue 的特性
 *
 */
public class LinkedListFeatures {
    public static void main(String [] args){
        LinkedList<Integer> integerLinkedList=new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8));
        System.out.println(integerLinkedList);
        System.out.println("integerLinkedList.getFirst()="+integerLinkedList.getFirst());
        System.out.println(integerLinkedList.element());
        System.out.println(integerLinkedList.peek());
        System.out.println(integerLinkedList.poll());
        System.out.println(integerLinkedList.removeFirst());
        System.out.println(integerLinkedList.remove());
        System.out.println(integerLinkedList.removeLast());
        System.out.println(integerLinkedList);

        integerLinkedList.addFirst(10);
        System.out.println(integerLinkedList);

        integerLinkedList.offer(11);
        System.out.println(integerLinkedList);

        integerLinkedList.add(12);
        System.out.println(integerLinkedList);

        integerLinkedList.addLast(14);
        System.out.println(integerLinkedList);


    }
}
