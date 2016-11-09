package fuyonglei.JichengYuChushihua;

/**
 * Created by kangyali on 4/2/16.
 * 继承与初始化
 * 1,编译器先执行的是Child.staitc 方法,加载器先去找Child类的编译代码(Child.class)
 * 2,在找的过程中通过extends知道Child 有一个基类Parent,ok 那我们先加载Parent.class
 * 3,加载Parent.class中static 先初始化,然后在初始化Clild.class 中的static 方法
 * 4,加载玩后,然后在执行static void main 中的方法
 * 6,构造了 了一个Child 的对象(继承的先调用基类的构造器(因为基类的构造器总是回先被调用))
 * 7,基于6 先找到了Child 的基类(Parent.class)的构造器,然后再初始化Child.class 的构造器
 * 结论:加载器在加载某个类的时候,会先找到这个类的基类,初始化基类的static方法,然后再初始化子类的static方法
 *     如果构造一个对象,也调用基类的构造器,再调用子类的构造器
 */
public class Child extends Parent {
    private int k=printInit("child.k initialized");
    public Child(){
        System.out.println("k=="+k+";j=="+j);
    }
    private static int x2=printInit("child.x2 initialized");
    public static void main(String [] args){
        System.out.println("child start");
        //Child child=new Child();
    }

}
