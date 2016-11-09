package iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author WanChuanLai
 * @create 6/21/16.
 */
public class Test {
    public static void main(String[] args)
    {
        List list=new ArrayList();
        listIteratorDemo2(list);
    }

    private static void listIteratorDemo2(List list) {
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");

        // 获取列表迭代器
        ListIterator it=list.listIterator();

        while(it.hasNext())
        {
            Object obj=it.next();
            if(obj.equals("abc2"))
            {
                it.add("hello");
            }
            System.out.println(obj);
        }
        System.out.println(list);
    }
}
