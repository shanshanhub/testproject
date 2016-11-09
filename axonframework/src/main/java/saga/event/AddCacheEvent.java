package saga.event;

/**
 * @author WanChuanLai
 * @create 9/12/16.
 */
public class AddCacheEvent {

    private String sagaId;
    private String cacheId;

    public AddCacheEvent(String sagaId, String cacheId) {
        this.sagaId = sagaId;
        this.cacheId = cacheId;
    }

    public String getSagaId() {
        return sagaId;
    }

    public void setSagaId(String sagaId) {
        this.sagaId = sagaId;
    }

    public String getCacheId() {
        return cacheId;
    }

    public void setCacheId(String cacheId) {
        this.cacheId = cacheId;
    }
}
