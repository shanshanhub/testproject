package com.comall.cybershop.trade.order.domain.event;

/**
 * @author WanChuanLai
 * @create 9/22/16.
 */
public class OrderCreatedEvent {
    private  OrderDTO orderDTO;

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }
}
