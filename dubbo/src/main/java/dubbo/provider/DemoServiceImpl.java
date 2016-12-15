package dubbo.provider;

import dubbo.service.DemoService;

/**
 * @author WanChuanLai
 * @create 11/9/16.
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        System.out.println(name);
        return name+"say hello";
    }
}
