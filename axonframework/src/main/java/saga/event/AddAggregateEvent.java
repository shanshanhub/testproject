package saga.event;

/**
 * @author WanChuanLai
 * @create 9/12/16.
 */
public class AddAggregateEvent {
    private String sagaId;

    private String aggregateId;

    public AddAggregateEvent(String sagaId, String aggregateId) {
        this.sagaId = sagaId;
        this.aggregateId = aggregateId;
    }

    public String getSagaId() {
        return sagaId;
    }

    public void setSagaId(String sagaId) {
        this.sagaId = sagaId;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(String aggregateId) {
        this.aggregateId = aggregateId;
    }
}
