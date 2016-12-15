package file;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author WanChuanLai
 * @create 12/14/16.
 */
public class Test {

    private static Map<String, LogInfo> logInfoMap = new HashMap<String, LogInfo>();
    private static Map<String, String> filter_LogInfoMap = new HashMap<String, String>();

    public static void main(String[] args) {
        File file = new File("/Users/kangyali/Downloads");
        File[] array = file.listFiles();
        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                System.out.println("*****" + array[i].getPath());
                readFileByLines(array[i].getPath());
            }
        }
        // readFileByLines("/Users/kangyali/Downloads/mobile-redis-subscribe.log");
        //readFileByLines("/Users/kangyali/Downloads/mobile-redis-publish.log");
        //writeFile("/Users/kangyali/temp/redistemp.log");


    }


    public static void readFileByLines(String fileName) {

        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                //  System.out.println("line " + line + ": " + tempString);
                LogInfo logInfo = JSONObject.parseObject(tempString, LogInfo.class);

                LogInfo getMap_logInfo = logInfoMap.get(logInfo.getUuid());

                if (getMap_logInfo == null) {
                    logInfoMap.put(logInfo.getUuid(), logInfo);
                } else {
                    writeMap(logInfo, getMap_logInfo);
                    logInfoMap.remove(logInfo.getUuid());


                }


                // 显示行号

                line++;
            }


            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static void writeFile(String filename) {
        try {
            File file = new File(filename);
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            for (Map.Entry<String, String> entry : filter_LogInfoMap.entrySet()) {
                System.out.println(entry.getValue().toString());
                bw.write(entry.getValue());
            }

            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void writeMap(LogInfo logInfo, LogInfo getMap_logInfo) {
        DateFormat f = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
        String logTime = f.format(new Date());
        JSONObject jitem = new JSONObject();
        jitem.put("uuid", logInfo.getUuid());
        jitem.put("logTime", logTime);
        if (logInfo.getType().equals("PUBLISH")) {
            jitem.put("publishKeyName", logInfo.getKeyName());
            jitem.put("subscribeKeyName", getMap_logInfo.getKeyName());
            jitem.put("publishTime", logInfo.getProcesstime());
            jitem.put("subscribeTime", getMap_logInfo.getProcesstime());
            jitem.put("interval", getMap_logInfo.getProcesstime() - logInfo.getProcesstime());
        } else {
            jitem.put("publishKeyName", getMap_logInfo.getKeyName());
            jitem.put("subscribeKeyName", logInfo.getKeyName());
            jitem.put("publishTime", getMap_logInfo.getProcesstime());
            jitem.put("subscribeTime", logInfo.getProcesstime());
            jitem.put("interval", logInfo.getProcesstime() - getMap_logInfo.getProcesstime());
        }


        filter_LogInfoMap.put(logInfo.getUuid(), jitem.toString() + System.getProperty("line.separator"));

    }


    private static void getDirectorysFile() {
        File file = new File("/Users/kangyali/Downloads");
        // get the folder list
        File[] array = file.listFiles();

        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
//                // only take file name
//                System.out.println("^^^^^" + array[i].getName());
//                // take file path and name
//                System.out.println("#####" + array[i]);
                // take file path and name
                System.out.println("*****" + array[i].getPath());
            } else if (array[i].isDirectory()) {
//                getFile(array[i].getPath());
            }
        }
    }

}
