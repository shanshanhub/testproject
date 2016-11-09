package code;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author WanChuanLai
 * @create 4/21/16.
 */
public class OrderTest {

    @Test
    public void testAdd() throws Exception {
        Order order=new Order();
        order.add(1);
    }

    @Test
    public void testDelete() throws Exception {
        Order order=new Order();
        order.delete(2);
    }
}