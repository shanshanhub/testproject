package createanddistoryobject;

/**
 * @author WanChuanLai
 * @create 9/26/16.
 *
 */
public class TestMain {
    public static void main(String [] args){
      //调用SingletionEnum,这样可以直接调用单个元素中的方法
        SingleonEnum.INSTANCE.leaveTheBuliding();
    }
}
