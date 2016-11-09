package test;


import futurework.OrderCreate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author WanChuanLai
 * @create 8/23/16.
 */
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class WorkTest extends AbstractTestNGSpringContextTests {

    @Test(invocationCount = 10, threadPoolSize = 2)
    public void testfuture()throws InterruptedException  {

        OrderCreate orderCreate=new OrderCreate();
        orderCreate.createOrder();
        Thread.sleep(1000);
    }

    @Test
    public void test() throws InterruptedException {
        OrderCreate orderCreate=new OrderCreate();
        orderCreate.createOrder();
        Thread.sleep(3000);
        //futuretest.DemoA demoA=new futuretest.DemoA();
        //demoA.createOrder();
    }
}
