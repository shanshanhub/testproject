package futurework;



/**
 * @author WanChuanLai
 * @create 8/25/16.
 */
public class WorkA implements WorkService {

    public boolean workrun() {
        try {
            System.out.println("A-----");
            Thread.sleep(5000);
            System.out.println("A1----------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
