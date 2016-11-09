package extendss;

/**
 * Created by kangyali on 3/30/16.
 */
public class FinalKey {
    public  final int i=0;
    public final  String aa="";
    public final Parent parent=new Parent(1);
    public void test(){
        //parent=new Parent(2);//引用类型的引用地址不能改变,指向的对象不能改变
        parent.aa="cccc";//但是这个对象的值可以改变
       // i=2;//基本类型的值不能改变
    }
    public static void main(String [] args){
        FinalKey finalKey=new FinalKey();
        finalKey.test();
    }
}
