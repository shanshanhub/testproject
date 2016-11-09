package comall.future.work;


import comall.future.WorkCheck;

/**
 * @author WanChuanLai
 * @create 8/25/16.
 */
public class WorkB implements WorkCheck {

    public boolean run() {
        try {
            System.out.println("B-----");
            Thread.sleep(3000);
            System.out.println("B1-----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
