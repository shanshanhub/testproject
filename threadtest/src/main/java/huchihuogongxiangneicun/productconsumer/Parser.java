package huchihuogongxiangneicun.productconsumer;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

/**
 * @author WanChuanLai
 * @create 8/29/16.
 * 定义一个生产者
 */
public class Parser implements Runnable{
    private BlockingQueue<Page> queue;
    public Parser(BlockingQueue<Page> queue){
        this.queue=queue;
    }
    public void run() {
        try {
//            Iterator<Page> iterator=new Page(10000l,"enwiki.xml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
