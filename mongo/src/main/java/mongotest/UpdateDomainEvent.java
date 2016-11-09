package mongotest;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;
import java.util.Iterator;

/**
 * @author WanChuanLai
 * @create 9/22/16.
 */
public class UpdateDomainEvent {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient mongoClient = new MongoClient("10.201.201.188", 27017);
        DB db = mongoClient.getDB("axontrade_songshu_online");
        DBCollection dbCollection = db.getCollection("domainevents");
        DBObject dbObject = BasicDBObjectBuilder.start().add("_id", new ObjectId("57ff6469bee865fc580731d4")).get();
        System.out.println(dbObject);

        DBCursor dbCursor = dbCollection.find(dbObject);
        Iterator<DBObject> iterator = dbCursor.iterator();
        int i = 0;

        while (iterator.hasNext()) {
            i++;
            System.out.println("i=" + i);
            DBObject objectSource = iterator.next();
            BasicDBObject query = new BasicDBObject("_id", objectSource.get("_id"));


            String strOrderCreatedEvent = objectSource.get("serializedPayload").toString();
            String mobile = strOrderCreatedEvent.substring(strOrderCreatedEvent.indexOf("<mobile>") + 8, strOrderCreatedEvent.indexOf("</mobile>"));

            strOrderCreatedEvent = strOrderCreatedEvent.replaceAll(mobile, "***********");

            objectSource.put("serializedPayload", strOrderCreatedEvent);

            BasicDBObject update = new BasicDBObject("serializedPayload", strOrderCreatedEvent);

            dbCollection.update(query, update);
//            }

//            System.out.println(iterator.next());
        }

    }
}

