package futurework;



/**
 * @author WanChuanLai
 * @create 8/25/16.
 */
public class WorkC implements WorkService {

    public boolean workrun() {
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
