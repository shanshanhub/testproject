package iterator.adapter;

import java.util.Arrays;

/**
 * @author WanChuanLai
 * @create 6/23/16.
 * 作用:适配器方法的惯用手法
 */
public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<String>(Arrays.asList("a", "e", "d"));

        //获取普通的迭代器//正序的输出 i++
        for (String string:ral) {
            System.out.println(string);
        }

        //handit 你的选择器上 //倒序的输出 i--
        for (String string:ral.reversed()){
            System.out.println(string);
        }
    }
}
