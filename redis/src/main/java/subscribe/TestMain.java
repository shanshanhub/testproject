package subscribe;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Executors;

/**
 * @author WanChuanLai
 * @create 12/24/16.
 */
public class TestMain {
    private static final Log logger = LogFactory.getLog(TestMain.class);


    public static void main(String[] args) {


        new Thread() {
            public void run() {

                System.out.println("＃＃＃订阅消息开始");
                // 订阅消息
                RedisMessageQueueUtil.subscribe(new LocalCacheRemoveSub());
            }
        }.start();


        new Thread() {
            public void run() {

                while (true) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Collection<String> stringList = new ArrayList<String>();

                    stringList.addAll(LocalCacheRemoveSub.stringList);

//                    System.out.println("size:" + stringList.size());

                    writeFile("/Users/kangyali/temp/redis_100_1m_100w-100_100_1.log", stringList);


                }
            }
        }.start();


    }

    public static File file = null;
    public static int count = 0;
    public static int filecount = 0;

    public static void writeFile(String filename, Collection<String> stringList) {

        try {
            if (file == null) {
                file = new File(filename);
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (stringList != null && stringList.size() > 0) {
                for (String str : stringList) {
                    if (str != null && str.length() > 0) {
                        bw.write(str);
                        bw.newLine();
                        LocalCacheRemoveSub.stringList.remove(str);
                    } else {
                        System.out.println("str is null");
                        LocalCacheRemoveSub.stringList.remove(str);
                    }
                    System.out.println("writevalue:count" + (++count) + ";" + str);
                }
            }

            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
