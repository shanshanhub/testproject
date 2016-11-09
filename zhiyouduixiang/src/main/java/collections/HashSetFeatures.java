package collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author WanChuanLai
 * @create 6/23/16.
 * 作用:HashSet 存的数据没有顺序,因为出于速度的考虑,HashSet 使用的散列函数
 */
public class HashSetFeatures {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<String>();
        Collections.addAll(stringSet, "a", "b", "c");
        stringSet.add("d");
        System.out.println(stringSet);

        Set<String> stringSet2=new HashSet<String>();
        Collections.addAll(stringSet2,"e","f","a","b");
        System.out.println(stringSet2);

        stringSet.removeAll(stringSet2);
        System.out.println(stringSet);



    }
}
