package ehcache;

import cache.Cache;

/**
 * @author WanChuanLai
 * @create 12/19/16.
 */
public class Ehcache implements Cache {
    public <K, V> V get(K key) {
        return null;
    }

    public <K, V> void put(K key, V value) {

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
