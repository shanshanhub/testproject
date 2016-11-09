package comall.future.work;


import comall.future.WorkCheck;
/**
 * @author WanChuanLai
 * @create 8/25/16.
 */
public class WorkC implements WorkCheck {

    public boolean run() {
        try {
            System.out.println("C-----");
            Thread.sleep(1000);
            System.out.println("C1-----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
