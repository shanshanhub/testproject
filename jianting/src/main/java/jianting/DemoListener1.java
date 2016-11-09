package jianting;

/**
 * @author WanChuanLai
 * @create 6/17/16.
 */
public class DemoListener1 implements DemoListener {
    public void handleEvent(DemoEvent de) {
        System.out.println("Inside listener1...");
        de.say();//回调
    }
}