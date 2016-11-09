package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author WanChuanLai
 * @create 6/21/16.
 * 作用:ListIterator 说明
 * ListIterator是一个更强大的Iterator的子类型,它只能用于各种list类的访问
 * --Iterator只能单向移动,而ListIterator可以双向移动
 * --产生相对于迭代器在列表中指向的当前位置的前一个和后一个元素的索引
 * --可以使用set()方法替换它访问过的最后一个元素
 * --可以通过调用listIterator()方法产生一个指向List开始处的ListIterator
 * <p>
 * ListIterator 的用处可以在对list循环中 判断添加或者删除时用到,避免下标越界
 */
public class ListIteratorFeatures {
    public static void main(String[] args) {
        List<Integer> integerList =new ArrayList(Arrays.asList(1, 2, 3, 4));
        ListIterator<Integer> listIterator = integerList.listIterator();

//        System.out.println("------从前往后输出list-----");
//        while (listIterator.hasNext()){
//            System.out.println(listIterator.next());
//        }
//        System.out.println("------从后往前输出------");
//        while (listIterator.hasPrevious()){
//            System.out.println(listIterator.previous());
//        }
//        System.out.println("------替换下标=3的元素--------");
//        listIterator=integerList.listIterator(3);
//        while (listIterator.hasNext()){
//            listIterator.next();
//            listIterator.set(5);
//        }
//        System.out.println(integerList);

//        System.out.println("--给list添加值:当值=2的时候,添加6--,就会在值=2 的下标后添加一个6元素");
//        while (listIterator.hasNext()) {
//            Integer integer=listIterator.next();
//            if(integer==2){
//                listIterator.add(6);
//            }
//            System.out.println(integer);
//
//        }
//        System.out.println(integerList);

        System.out.println("--给list删除值:当值=2的时候,删除这个元素");
        while (listIterator.hasNext()) {
            Integer integer=listIterator.next();
            if(integer==2){
                listIterator.remove();
            }
            System.out.println(integer);

        }
        System.out.println(integerList);

    }

}
