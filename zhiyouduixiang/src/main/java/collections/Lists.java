package collections;

import vo.Heavy;
import vo.Light;
import vo.Snow;

import java.util.*;

/**
 * @author WanChuanLai
 * @create 5/6/16.
 * 两种类型的list
 * ArrayList 随机访问的速度快,插入和移除的速度慢
 * LinkedList 随机访问速度慢,插入和移除的速度快
 */
public class Lists {
    public  void main2(String [] args){
        //ArrayList  操作
        Collection<Integer> collection=new ArrayList<Integer>(4);

        Integer [] moreInts= {6,7,8,9,10};
        //转换为collection类型的
        collection.addAll(Arrays.asList(moreInts));

        Collections.addAll(collection,11,12,13,14);
        //方法方便,直接可以插入数组,可以为任何类型的哈
        Collections.addAll(collection,moreInts);

        List<Integer> list1=Arrays.asList(15,16,17);
        for (Integer i:collection) {
            System.out.println(i);
        }
        //在Arrays.asList中间插入一条线索,以告诉编译器对于由Arrays.asList产生的list类型,实际的目的类型是什么.
        //这种称为显示类型参数说明
        List<Snow> l_snow=Arrays.<Snow>asList(new Light(),new Heavy());
        for (Snow snow:l_snow){
            if(snow.getClass()==Light.class){
                Light light=(Light)snow;
                System.out.println(light.toString());
            }
            if(snow.getClass()==Heavy.class){
                Heavy heavy=(Heavy) snow;
                System.out.println(heavy.toString());
            }
        }





    }

     void OperatorArrayList(){
        Random random=new Random(47);

    }

    public static void main(String [] args){
        Map<String,Object> objectMap=new HashMap<String, Object>();
        objectMap.put("key1","66666");
        List<String> stringlist=new ArrayList<String>();
        List list=(List)objectMap.values();
        stringlist.addAll(list);
        System.out.println(stringlist);

    }
}
