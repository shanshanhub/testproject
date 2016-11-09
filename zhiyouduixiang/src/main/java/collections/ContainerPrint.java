package collections;

import java.util.*;

/**
 * @author WanChuanLai
 * @create 5/9/16.
 * 容器打印
 */
public class ContainerPrint {
    static Collection fill(Collection<String> collection){
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }
    static Map fill(Map<String,String> map){
        map.put("rat","Fuzzy");
        map.put("cat","Rags");
        map.put("dog","Bosco");
        map.put("dog","Spot");
        return map;
    }
    public static void main(String [] args){
        //Collection
        //List 以特定的顺序保存一组元素 ArrayList /ListedList
        //set 元素不能重复 HashSet/TreeSet/LinkedHashSet
        //Queue 只允许在容器的另一端 插入对象,并从另一端移除

        //List:有序可以重复
        //ArrayList list 类型,按照插入的顺序保存元素 List的中间插入和移除元素时比较慢,随机查询快
        System.out.println(fill(new ArrayList<String>()));

        //LinkedList list 类型,按照插入的顺序保存元素 插入和删除快,提供了优化的顺序访问,查询很慢
        System.out.println(fill(new LinkedList<String>()));

        //Set:无序不可以重复
        //HashSet set 类型,元素不能重复,最快的获取元素的方式,不关心set中的顺序
        System.out.println(fill(new HashSet<String>()));

        //TreeSet set类型,元素不能重复,如果存储顺序很重要,可以使用,按照升序保存对象
        System.out.println(fill(new TreeSet<String>()));

        //LinkedHashSet set 类型,元素不能重复,按照元素添加的顺序保存
        System.out.println(fill(new LinkedHashSet<String>()));

       //Map
        //HashMap 提供了最快的查找技术
        System.out.println(fill(new HashMap<String, String>()));

        //TreeMap 按照比较后的结果升序保存键
        System.out.println(fill(new TreeMap<String, String>()));

        //LinkedHashMap 按照插入顺序保存键,同时还保留了HashMap的查询速度
        System.out.println(fill(new LinkedHashMap<String, String>()));
    }
}
