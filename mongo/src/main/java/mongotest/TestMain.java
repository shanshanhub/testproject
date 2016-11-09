package mongotest;

import com.mongodb.*;
import org.axonframework.saga.Saga;
import org.axonframework.saga.repository.mongo.SagaEntry;
import org.axonframework.serializer.JavaSerializer;
import org.axonframework.serializer.Serializer;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;

/**
 * @author WanChuanLai
 * @create 9/9/16.
 */
public class TestMain {
    public static void main(String [] args) throws UnknownHostException {
       // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mongodb.xml");
        MongoClient mongoClient = new MongoClient("10.90.6.28", 27017);

        DB db = mongoClient.getDB("axontrade_songshu_online");
        DBCollection dbCollection= db.getCollection("sagacollection");
        System.out.println(dbCollection);

        DBObject dbObject=BasicDBObjectBuilder.start().add( "sagaIdentifier" ,"df2f88d2-65a4-4b8e-af46-2ea7a6a475cc").get();
        System.out.println(dbObject);

//        DBCursor dbCursor= dbCollection.find(dbObject);
//
//        Iterator<DBObject> iterator=dbCursor.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        //获取一个
        DBObject dbSaga = dbCollection.findOne(dbObject);

        SagaEntry sagaEntry = new SagaEntry(dbSaga);

        Serializer serializer=new JavaSerializer();
        Saga loadedSaga = sagaEntry.getSaga(serializer);

        System.out.println(loadedSaga.isActive());

    }
}
