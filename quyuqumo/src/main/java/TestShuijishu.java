import java.util.Random;

/**
 * @author WanChuanLai
 * @create 12/23/16.
 */
public class TestShuijishu {
    public static void main(String [] args){
        for (int i=0;i<200;i++){
            random();
        }

    }
    /**
     * 随机生成100以内的随机数
     */
    public static void random(){
        Random random = new Random();
        int n = random.nextInt(100);
        System.out.println(n);
    }

    /**
     * 随机生成100以内的随机数
     */
    public static void random2(){
        int n = (int)(Math.random()*200);
        System.out.println(n);
    }

}
