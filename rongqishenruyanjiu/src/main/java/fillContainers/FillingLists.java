package fillContainers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author WanChuanLai
 * @create 6/23/16.
 */
public class FillingLists {
    public static void main(String [] args){
        System.out.println("----Collections.nCopies添加时复制多个对象---");
        List<StringAddress> list=new ArrayList<StringAddress>
                (Collections.nCopies(4,new StringAddress("hello")));
        System.out.println(list);

        System.out.println("----Collections.fill替换已经在List中存在的所有元素,不能添加元素---");
        Collections.fill(list,new StringAddress("HELLO"));
        System.out.println(list);

    }
}
