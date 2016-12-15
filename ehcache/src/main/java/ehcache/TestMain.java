package ehcache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author WanChuanLai
 * @create 12/6/16.
 * spring ehcache test
 */
public class TestMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-ehcache.xml"});
        context.start();
        Ehcache ehcache = (Ehcache) context.getBean("recommendCache1");
        List<Goods> goodsList = new ArrayList<Goods>();
        for (int i = 0; i < 1; i++) {
            Goods goods = new Goods(i, 1, "", 1, 1, 1, 1, new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), 1, new Date(), 1, 1, true, new Date(), 1, new Date(), 1, 1);
            goodsList.add(goods);
        }


        ehcache.put(new Element("key", goodsList, true));

        Element element = ehcache.get("key");
        List<Goods> goodsLists = (List<Goods>) element.getObjectValue();
        for (Goods good : goodsLists) {
            System.out.println(good.getId());
        }

    }
}
