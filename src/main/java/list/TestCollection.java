package list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by kangyali on 3/18/16.
 */
 class TestCollection{

   // @PreDestory
    public void show(){
        HashMap<String,String> map=new HashMap<String, String>();
        map.put("aa","bb");
    }
    public static boolean is_test;
    public static void main(String [] args){
//        LinkedList linkedList=new LinkedList();
//        linkedList.add("aaaaaa");
//        ArrayList arrayList=new ArrayList();
//        arrayList.add("aaaaa");
//        String aa;
//        System.out.print(aa);
//        String cc=new String();
//        System.out.print(cc);

//        System.out.print(is_test);
//        StaticClassTest test=new StaticClassTest();
//        test.ii++;
//        System.out.println(test.ii);
//        StaticClassTest test2=new StaticClassTest();
//        System.out.println(test.ii);

        Date data=new Date();
        System.out.println(data);


    }
    public void aa(){

    }
}
