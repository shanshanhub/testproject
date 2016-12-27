import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author WanChuanLai
 * @create 12/23/16.
 */
public class TestObjectByteSize {
    public static void main(String[] args) {
//        objectsize();
//        goods.

        stringsize();

    }

    public static void stringsize() {
        String object = "wanchuanlaiwanchuanlaiwanchuanla";
        int bytelength = object.getBytes().length;
        System.out.println(bytelength);
    }

    public static void objectsize() {
        List<Goods> goodsList=new ArrayList<Goods>();

        for (int i=0;i<4000;i++){
            Goods goods = new Goods(1, 1, "万测试测试测试wan", 121212, 1, 1, 1, new BigDecimal(12345), new BigDecimal(232323), new BigDecimal(1212121), 234234, new Date(), 234234, 1, true, new Date(), 23432423, new Date(), 1, 1, "传传传传", "来来来来wa");
            goodsList.add(goods);
        }

        byte[] bytes = null;
        try {
            // object to bytearray
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(goodsList);

            bytes = bo.toByteArray();

            bo.close();
            oo.close();
        } catch (Exception e) {
            System.out.println("translation" + e.getMessage());
            e.printStackTrace();
        }
        int bytelength = bytes.length;
        System.out.println(bytelength);

    }
}
