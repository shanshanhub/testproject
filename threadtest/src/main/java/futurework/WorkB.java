package futurework;


/**
 * @author WanChuanLai
 * @create 8/25/16.
 */
public class WorkB implements WorkService {

    public boolean workrun() {
        try {
            System.out.println("B-----");
            Thread.sleep(3000);
            System.out.println("B1-----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
