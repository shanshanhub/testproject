package collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

/**
 * @author WanChuanLai
 * @create 6/21/16.
 * 作用:ArrayList遍历
 * ArrayList 底层是数组封装的,在取单个数时很快
 * for 循环是最快的
 *
 * 测试:
 * 10000000 的数据
 * 第一种平均时间:25-32
 * 第二种平均时间:24-30
 * 第三种平均时间:22-24
 * 第五中平均时间:30-35
 */
public class ArrayListOutPut {
    public static void main(String [] args){
        //List<Integer> list1= Arrays.asList(15,16,17);
        List<Integer> list1=new ArrayList<Integer>();
        for (int i=0;i<10000000;i++) {
            list1.add(i);
        }

//        System.out.println("one-starttime="+new Date().getTime());
//        Iterator<Integer> it=list1.iterator();
//        //第一种遍历
//        while (it.hasNext()){
//            Integer integer=it.next();
//           // System.out.println(it.next());
//        }
//        System.out.println(" one-startend="+new Date().getTime());


//        System.out.println("two-starttime="+new Date().getTime());
//        //第二种遍历
//        for (Integer integer:list1) {
//            Integer i=integer;
//            //System.out.println(integer);
//        }
//
//        System.out.println("two-starttime="+new Date().getTime());


//        System.out.println("three-starttime="+new Date().getTime());
//        //第三种遍历
//        int count=list1.size();
//        for (int i=0;i<count;i++){
//            Integer inte=list1.get(i);
//        }
//
//        System.out.println("three-endtime="+new Date().getTime());
//
//
//        System.out.println("four-starttime="+new Date().getTime());
//        //第四种遍历
//        for (int i=0;i<list1.size();i++){
//            Integer inte=list1.get(i);
//        }
//
//        System.out.println("four-endtime="+new Date().getTime());


        System.out.println("five-starttime="+new Date().getTime());
        ListIterator<Integer> listIterator=list1.listIterator();
        while (listIterator.hasNext()){
            Integer integer=listIterator.next();
        }
        System.out.println("five-starttime="+new Date().getTime());

    }
}
