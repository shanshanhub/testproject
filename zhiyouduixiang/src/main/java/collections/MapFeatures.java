package collections;

import java.util.*;

/**
 * @author WanChuanLai
 * @create 5/6/16.
 */
public class MapFeatures {
    public static Map<Integer,List<String>> integerListMap=new HashMap<Integer, List<String>>();
    static {
        integerListMap.put(1,new ArrayList<String>(Arrays.asList("a","b","c")));
        integerListMap.put(2,new ArrayList<String>(Arrays.asList("d","e","f")));
        integerListMap.put(3,new ArrayList<String>(Arrays.asList("g","h","i")));
    }
    public static void main(String [] args){
        System.out.println(integerListMap.get(1));
    }
}
