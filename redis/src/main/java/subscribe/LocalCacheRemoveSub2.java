package subscribe;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.JedisPubSub;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 本地缓存驱逐消息订阅
 *
 * @author Zero
 */

public class LocalCacheRemoveSub2 extends JedisPubSub {
    public static List<String> stringList = Collections.synchronizedList(new ArrayList<String>());

    private static int count = 0;


    /**
     * 接受消息事件
     */
    @Override
    public void onMessage(String channel, String message) {

        Long subscribeTime = System.nanoTime();

        DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS", Locale.ENGLISH);
        String logTime = f.format(new Date());
//        System.out.println("接收到消息:" + message + "(" + (++count) + ")");
        // 获取消息对象
//        JSONObject data = null;
//        try {
//            data = (JSONObject) JSON.parse(message);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (data != null) {
//            Long publishTime = data.getLong("publishTime");
//            Long interval = subscribeTime - publishTime;
//
//            JSONObject jitem = new JSONObject();
//            jitem.put("keyName", data.getString("keyName"));
//            jitem.put("interval", interval);
//            jitem.put("subscribeTime", subscribeTime);
//            jitem.put("publishTime", publishTime);
//            jitem.put("logTime", logTime);
//            String jsonstr = jitem.toJSONString();
//            if (jsonstr == null || jsonstr.length() <= 0) {
//                System.out.println("jsonstr is null");
//            }
//            stringList.add(jsonstr);
//            //logger.info(jitem.toJSONString());
//
//        }
    }

    /**
     * 订阅消息事件
     */
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        // 订阅成功
        super.onSubscribe(channel, subscribedChannels);
        System.out.println("onSubscribe OK");
    }
}
