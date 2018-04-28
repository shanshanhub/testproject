package brigde;

/**
 * <p>类名注释</br>类的用途</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年04月15日 11:27.
 */
public class EmailMessageSender implements MessageSender {
    @Override
    public void sendMessage() {
        System.out.println("EmailMessageSender: Sending email message...");
    }
}
