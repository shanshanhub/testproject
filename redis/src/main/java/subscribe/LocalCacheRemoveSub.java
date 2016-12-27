package subscribe;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.JedisPubSub;


/**
 * 本地缓存驱逐消息订阅
 * @author Zero
 *
 */

public class LocalCacheRemoveSub extends JedisPubSub {

	private static int count = 0;


	/**
	 * 接受消息事件
	 */
	@Override
	public void onMessage(String channel, String message) {
		System.out.println("接收到消息:"+message+"("+(++count)+")");
		// 获取消息对象
		JSONObject data = null;
		try {
			data = (JSONObject) JSON.parse(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(data != null) {

		}
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
