package saga.mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import org.axonframework.saga.repository.mongo.MongoTemplate;
import org.springframework.data.mongodb.MongoDbFactory;

/**
 * @author WanChuanLai
 * @create 9/12/16.
 */
public class CFSagaMongoTemplate implements MongoTemplate {
    private static final String SAGA_COLLECTION = "sagacollection";
    private MongoDbFactory mongoDbFactory;

    public CFSagaMongoTemplate(MongoDbFactory mongoDbFactory) {
        this.mongoDbFactory = mongoDbFactory;
    }


    public DBCollection sagaCollection() {
        return database().getCollection(SAGA_COLLECTION);
    }

    private DB database() {
        return mongoDbFactory.getDb();
    }
}
