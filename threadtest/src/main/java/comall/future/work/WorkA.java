package comall.future.work;


import comall.future.WorkCheck;

/**
 * @author WanChuanLai
 * @create 8/25/16.
 */
public class WorkA implements WorkCheck {

    public boolean run() {
        try {
            System.out.println("A-----");
            Thread.sleep(1);
            System.out.println("A1----------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
