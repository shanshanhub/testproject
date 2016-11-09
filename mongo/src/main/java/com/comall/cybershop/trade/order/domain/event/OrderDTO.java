package com.comall.cybershop.trade.order.domain.event;

/**
 * @author WanChuanLai
 * @create 9/28/16.
 */
public class OrderDTO {

    /**
     * 订单配送信息
     */
    private OrderDeliveryDTO orderDelivery;

    public OrderDeliveryDTO getOrderDelivery() {
        return orderDelivery;
    }

    public void setOrderDelivery(OrderDeliveryDTO orderDelivery) {
        this.orderDelivery = orderDelivery;
    }
}
