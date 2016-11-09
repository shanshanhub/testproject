package mongotest;

import com.comall.cybershop.trade.order.domain.event.OrderCreatedEvent;
import com.mongodb.*;
import com.thoughtworks.xstream.XStream;

import java.net.UnknownHostException;
import java.util.Iterator;

/**
 * @author WanChuanLai
 * @create 9/28/16.
 */
public class UpdateDomainEvent2 {
    public static void main(String [] args) throws UnknownHostException {
        MongoClient mongoClient = new  MongoClient("10.90.6.28", 27017);;
        DB db = mongoClient.getDB("axontrade_songshu_online");
        DBCollection dbCollection = db.getCollection("domainevents");
        BasicDBObject basicDBObject=new BasicDBObject("payloadType","com.comall.cybershop.trade.order.domain.event.OrderCreatedEvent");


        DBCursor dbCursor = dbCollection.find(basicDBObject);

        Iterator<DBObject> iterator = dbCursor.iterator();
        while (iterator.hasNext()) {
            DBObject objectSource = iterator.next();

            String serializedContent = objectSource.get("serializedPayload").toString();

            XStream xstream = new XStream();
            OrderCreatedEvent orderCreatedEvent = (OrderCreatedEvent) xstream.fromXML(serializedContent);
            confusionMobile(orderCreatedEvent.getOrderDTO().getOrderDelivery().getMobile());
            confusionAddress(orderCreatedEvent.getOrderDTO().getOrderDelivery().getAddress());
            confusionEmail(orderCreatedEvent.getOrderDTO().getOrderDelivery().getEmail());
            confusionPhone(orderCreatedEvent.getOrderDTO().getOrderDelivery().getPhone());

            String updateSerializedContent = xstream.toXML(orderCreatedEvent);

            BasicDBObject query=new BasicDBObject("_id",objectSource.get("_id"));
            BasicDBObject update=new BasicDBObject("serializedPayload",updateSerializedContent);

            dbCollection.findAndModify(query, update);

        }
    }

    private static void confusionMobile(String mobile){
        mobile=mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1cccc$2");
    }
    private static void confusionAddress(String address){
        address=address.replaceAll(address,"*");
    }
    private static void confusionPhone(String phone){
        phone=phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1**");
    }
    private static void confusionEmail(String email){
        email=email.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1**");
    }

}
