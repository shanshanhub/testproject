package ehcache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author WanChuanLai
 * @create 1/10/17.
 */
public class TestSearch {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-ehcache.xml"});
        context.start();

        Ehcache ehcache = (Ehcache) context.getBean("recommendCache1");
        User user = new User("wanchuanlai");
        ehcache.put(new Element("userName", user));
        Attribute<String> nameAttribute = ehcache.getSearchAttribute("name");

        Query query = ehcache.createQuery();
        query.addCriteria(nameAttribute.eq("userName"));
        Results results = query.execute();
        List<Result> result_list = results.all();
        for (Result result : result_list) {
            System.out.println("key:" + result.getKey() + ";" + result.getValue());
        }
    }

}
