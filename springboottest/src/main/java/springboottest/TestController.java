package springboottest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>类名注释</br>类的用途</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年04月10日 14:19.
 */
@RestController
@RequestMapping("/task")
public class TestController {
    public AtomicInteger atomicInteger = new AtomicInteger(0);

    @PutMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void add(String message) throws Exception {
        addThread(Integer.parseInt(message));
    }

    private void addThread(int count) {
        ThreadUtil.initThreadTool().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("开启线程");
                try {
                    Thread.sleep(1000 * 60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程数:" + atomicInteger.incrementAndGet());
            }
        });


    }
}
