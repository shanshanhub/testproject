package collections;

import java.util.*;

/**
 * @author WanChuanLai
 * @create 6/22/16.
 * 作用:Set
 * 1,set不保存重复的元素
 * 2,HashSet 存的数据没有顺序,因为出于速度的考虑,HashSet 使用的散列函数
 * 3,TreeSet 存的数据由小到大升序排列,TreeSet 存储在红-黑数据结构中
 * 4,LinkedHashSet 按照插入的顺序存储
 *
 */
public class SetFeatures {
    public static void main(String [] args){
        Random rand=new Random(47);

//        //HashSet
        Set<Integer> intHashset=new HashSet<Integer>();
        for (int i=0;i<10000;i++){
            intHashset.add(rand.nextInt(30));
        }
        System.out.println(intHashset);//元素不重复,没有顺序

//        SortedSet<Integer> intTreeset=new TreeSet<Integer>();
//        for (int i=0;i<10000;i++){
//            intTreeset.add(rand.nextInt(30));
//        }
//        System.out.println(intTreeset);//元素不重复,数据由小到大升序排列

//        Set<Integer> intLinkedSet=new LinkedHashSet<Integer>();
//        for (int i=0;i<10000;i++){
//            intLinkedSet.add(rand.nextInt(30));
//        }
//        System.out.println(intLinkedSet);//元素不重复,数据按照插入顺序存储

    }
}
