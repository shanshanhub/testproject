package hibernate;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author WanChuanLai
 * @create 12/13/16.
 */
public class Test {
    public static void main(){
        //读取hibernate.cfg.xml文件
        Configuration cfg = new Configuration().configure();

        //建立SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();

//        //取得session
        org.hibernate.Session session = null;
        try {
            session = factory.openSession();
            session.createQuery("select * from user").setCacheable(true).list();
            //开启事务
            session.beginTransaction();
            BIConversion.User user = new BIConversion.User();
//            user.setName("张三");
//            user.setPassword("123");
//            user.setCreateTime(new Date());
//            user.setExpireTime(new Date());

            //保存User对象
            session.save(user);

            //提交事务
            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            //回滚事务
            session.getTransaction().rollback();
        }finally {
            if (session != null) {
                if (session.isOpen()) {
                    //关闭session
                    session.close();
                }
            }
        }

    }
}
