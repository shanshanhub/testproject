package collections;

import java.util.*;

/**
 * @author WanChuanLai
 * @create 5/6/16.
 * 作用:先进先出
 * 1,LinkedList 实现了Queue接口
 * 2,PriorityQueue(优先级队列) 描述了最典型的队列规则,队列规则是指在给定一组队列中的元素的情况下,确定下一个弹出队列的元素的规则,
 *   优先级队列声明下一个弹出元素最需要的元素(具有最高的优先级)
 */
public class QueueFeatures {
    public static void main(String [] args){
        //1,LinkedList
        Queue<Integer> integerQueue=new LinkedList<Integer>();

        //2,PriorityQueue(优先级队列)

        //可以按照先进先出的顺序出 //[0, 1, 1, 1, 1, 14, 3, 8, 1, 5]
        PriorityQueue<Integer> integerPriorityQueue=new PriorityQueue<Integer>();
        Random random=new Random(47);
        for(int i=0;i<10;i++){
            integerPriorityQueue.offer(random.nextInt(i+10));
        }
        System.out.println(integerPriorityQueue);

        //队列里面的值可以重复//[2, 3, 4, 6, 6, 10, 5, 9]
        List<Integer> integerList=Arrays.asList(6,9,10,2,3,4,5,6);
        integerPriorityQueue=new PriorityQueue<Integer>(integerList);
        System.out.println(integerPriorityQueue);

        //比如,如果你想最大的值先出//[10, 6, 9, 6, 3, 4, 5, 2]
        integerPriorityQueue=new PriorityQueue<Integer>(integerList.size(),Collections.<Integer>reverseOrder());
        integerPriorityQueue.addAll(integerList);
        System.out.println(integerPriorityQueue);

        //想要最大的值先出,且队列中的值不重复
        Set<Integer> integerSet=new HashSet<Integer>();
        Collections.addAll(integerSet,5,3,9,2,5);
        integerPriorityQueue=new PriorityQueue<Integer>(integerSet.size(),Collections.<Integer>reverseOrder());
        integerPriorityQueue.addAll(integerSet);
        System.out.println(integerPriorityQueue);




    }
}
