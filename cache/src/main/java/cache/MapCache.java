package cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author WanChuanLai
 * @create 12/19/16.
 */
public class MapCache implements Cache {

    ConcurrentMap<Object,Object> concurrentMap=new ConcurrentHashMap<Object,Object>();
    public <K, V> V get(K key) {
        return (V) concurrentMap.get(key);
    }

    public <K, V> void put(K key, V value) {
        concurrentMap.put(key,value);
    }

    public <K, V> boolean putIfAbsent(K key, V value) {
        return false;
    }

    public <K> boolean remove(K key) {
        return false;
    }

    public <K> boolean containsKey(K key) {
        return false;
    }

    public void registerCacheEntryListener(EntryListener cacheEntryListener) {

    }

    public void unregisterCacheEntryListener(EntryListener cacheEntryListener) {

    }
}
