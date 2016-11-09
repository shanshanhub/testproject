package saga.event;

/**
 * @author WanChuanLai
 * @create 9/12/16.
 */
public class AddDbEvent {
    private String sagaId;
    private String dbId;

    public AddDbEvent(String sagaId,String dbId) {
        this.dbId = dbId;
        this.sagaId = sagaId;
    }

    public String getSagaId() {
        return sagaId;
    }

    public void setSagaId(String sagaId) {
        this.sagaId = sagaId;
    }

    public String getDbId() {
        return dbId;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }
}
