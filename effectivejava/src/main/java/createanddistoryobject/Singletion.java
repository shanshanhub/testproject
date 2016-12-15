package createanddistoryobject;

/**
 * @author WanChuanLai
 * @create 9/26/16.
 * 用私有构造器或者枚举类型强化Singletion属性
 * 第一种方法:共有静态成员是final域
 * 第三种:只需要编写一个包含单个单元的枚举类型
 *       这种无偿提供了反射华机制,绝对防止多次实例化,这种方法虽然没有广泛运用,
 *       但是 单元素的枚举已经成为实现Singletion的最佳方式
 *       查看代码SingleonEnum.java
 */
public class Singletion {

    //第一种方法 begin
//    public static final Singletion INSTANCE=new Singletion();
//    private Singletion(){
//
//    }
    //第一种方法 end
    //第一种方法享有特权的的客户端可以借助AccessibleObject.setAccessible,通过反射机制
    //调用私有构造器,

    //第二种方法begin
    private static final Singletion INSTANCE=new Singletion();

    private Singletion(){

    }
    public static Singletion getInstance(){
        return INSTANCE;
    }

    //第二种方法end

    public void leaveTheBuliding(){

    }

}
