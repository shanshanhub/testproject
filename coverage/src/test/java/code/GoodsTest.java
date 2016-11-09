package code;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author WanChuanLai
 * @create 4/21/16.
 */
public class GoodsTest {

    @Test
    public void testAdd() throws Exception {
        Goods goods=new Goods();
        goods.add(1);
    }

    @Test
    public void testDelete() throws Exception {
        Goods goods=new Goods();
        goods.delete(1);
    }
}