package futuretask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public class TestMain {
    public static void main(String [] args){
        long begin = System.currentTimeMillis();
        ExecutorService executorService= Executors.newCachedThreadPool();

        executorService.submit(new MemberAddressValidation(new MemberAddressCallable()));
        executorService.submit(new DeliveryAreaValidation(new DeliveryAreaValidationCallable()));
        executorService.submit(new PaymentPasswordValidation(new PaymentPasswordCallable()));
        executorService.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("end-begin="+(end-begin));

    }
}
