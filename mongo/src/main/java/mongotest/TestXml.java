package mongotest;

import com.comall.cybershop.common.util.StringUtils;
import com.comall.cybershop.trade.order.domain.event.OrderCreatedEvent;
import com.comall.cybershop.trade.order.domain.event.OrderDTO;
import com.comall.cybershop.trade.order.domain.event.OrderDeliveryDTO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * @author WanChuanLai
 * @create 10/14/16.
 */
public class TestXml {
    public static void main(String [] args){
        String phone="****";
        phone.replaceAll("QQQQ", "****");
//
//        if(!StringUtils.isEmpty(phone )&&phone.length() >= 8) {
//            phone = phone.replaceAll(phone.substring(phone.length() - 4), "****");
//        }
        System.out.println(phone);

    }
}
