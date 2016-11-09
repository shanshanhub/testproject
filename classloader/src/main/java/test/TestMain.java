package test;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.net.URL;

/**
 * @author WanChuanLai
 * @create 8/22/16.
 */
public class TestMain {
    public static void main(String [] args){
        try {
            String path = "classpath:aa.data";
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = new Resource[0];

            resources = resolver.getResources(path);

            URL uri = resources[0].getURL();
            UrlResource pathResource = new UrlResource(uri);
            EncodedResource er = new EncodedResource(pathResource, "utf-8");
            String content = FileCopyUtils.copyToString(er.getReader());
            System.out.println(content);
            //  orders = JSONObject.parseArray(content, Order.class);
        } catch (IOException e) {

        }
    }
}
