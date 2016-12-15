package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WanChuanLai
 * @create 11/29/16.
 */
public class TestJsonToMap {
    public static void main(String [] args){
        Map<String,TestEntity> map=new HashMap<String, TestEntity>();
        TestEntity testEntity=new TestEntity();
        testEntity.setEternal(false);
        testEntity.setTimeToIdleSeconds(1);
        testEntity.setTimeToLiveSeconds(2);

        TestEntity testEntity2=new TestEntity();
        testEntity2.setEternal(false);
        testEntity2.setTimeToIdleSeconds(1);
        testEntity2.setTimeToLiveSeconds(2);
        List<EhCacheKeys> ehCacheKeysList=new ArrayList<EhCacheKeys>();
        EhCacheKeys ehCacheKey=new EhCacheKeys();
        ehCacheKey.setKey("key1");
        ehCacheKey.setTestEntity(testEntity);
        ehCacheKeysList.add(ehCacheKey);

        EhCacheKeys ehCacheKey2=new EhCacheKeys();
        ehCacheKey2.setKey("key2");
        ehCacheKey2.setTestEntity(testEntity2);
        ehCacheKeysList.add(ehCacheKey2);

        String json= JSONObject.toJSONString(ehCacheKeysList);

        System.out.println(json);
        //JSONObject jsonObject= JSON.parseObject(json);




    }
}
