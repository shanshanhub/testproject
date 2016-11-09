package collections;

import vo.Snow;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WanChuanLai
 * @create 8/17/16.
 */
public class SingletonListTest {
    public static void main(String [] args){
        Map<String , Snow> map=new HashMap<String, Snow>();
        List<Snow> list= Collections.singletonList(map.get("aa"));
        System.out.println(list.size());
    }
}
