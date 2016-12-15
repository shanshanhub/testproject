package serializetest;

/**
 * @author WanChuanLai
 * @create 12/8/16.
 */
public class TestReturn {
    public static void main(String[] args) {
        subscribe(0);
    }

    private static final boolean flag = true;

    public static int subscribe(int retryTime) {
        try {
            if (retryTime<=3) {
                test();
                System.out.println("aaaaaaa");
            }
            return 0;
        } catch (Exception ex) {
            System.out.println("error");
            retryTime=retryTime+1;
            return subscribe(retryTime);
        }finally {
            System.out.println("finally");
        }

    }

    public static void test() throws Exception {

        throw new Exception("error");

    }
}

