package fuyonglei.JichengYuChushihua;

/**
 * Created by kangyali on 4/2/16.
 */
public class Parent {
    private int i=9;
    protected int j;
    Parent(){
        System.out.println("i=="+i+"; j="+j);
        j=39;
    }
    private static int x1=printInit("parent.x1 initialized");
    static int printInit(String s){
        System.out.println(s);
        return 47;
    }
}
