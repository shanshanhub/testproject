package cache;

/**
 * @author WanChuanLai
 * @create 12/19/16.
 */
public interface Cache {


    <K, V> V get(K key);

    <K, V> void put(K key, V value);

    <K, V> boolean putIfAbsent(K key, V value);

    <K> boolean remove(K key);

    <K> boolean containsKey(K key);

    void registerCacheEntryListener(EntryListener cacheEntryListener);

    void unregisterCacheEntryListener(EntryListener cacheEntryListener);

    interface EntryListener {

        void onEntryExpired(Object key);

        void onEntryRemoved(Object key);

        void onEntryUpdated(Object key, Object value);

        void onEntryCreated(Object key, Object value);

        void onEntryRead(Object key, Object value);

        Object clone() throws CloneNotSupportedException;
    }

}
