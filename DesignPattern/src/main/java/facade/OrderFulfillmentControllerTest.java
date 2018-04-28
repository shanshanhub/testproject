package facade;

import facade.controller.OrderFulfillmentController;
import facade.servicefacade.OrderServiceFacadeImpl;

/**
 * <p>类名注释</br>类的用途</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年04月28日 09:40.
 */
public class OrderFulfillmentControllerTest {
    public static void main(String[] args) {
        OrderFulfillmentController controller = new OrderFulfillmentController();
        controller.facade = new OrderServiceFacadeImpl();
        controller.orderProduct(9);
        boolean result = controller.orderFulfilled;

    }
}
