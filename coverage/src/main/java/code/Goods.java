package code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author WanChuanLai
 * @create 4/21/16.
 */
public class Goods {
    public static final Set<Object> eventHashSet = new HashSet<Object>(Arrays.asList(Goods.class));

    public void add(int i){

    }
    public void delete(int j){

    }
    private static boolean before(Object event){

        boolean iscontains=eventHashSet.contains(event.getClass());
        return iscontains;
    }
    public static void main(String [] args){
        Goods goods=new Goods();
        System.out.print(goods.getClass());
        before(goods);
        int count=0;
        long aa=1000*60*60*24*30;
        System.out.print(aa);


    }
}
