package extendss;

/**
 * Created by kangyali on 3/30/16.
 * 在之类被构造之前,基类会先被构造
 */
public class ChildOne extends Parent {
    public ChildOne(){
        super(1);
        System.out.print("构造ChildOne");
    }
    public static void main(String [] args){
        ChildOne childOne=new ChildOne();
        System.out.println("ccccc");
    }
}

