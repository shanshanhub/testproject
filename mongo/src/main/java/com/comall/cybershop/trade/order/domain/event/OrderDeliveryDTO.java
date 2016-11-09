package com.comall.cybershop.trade.order.domain.event;

import java.util.Date;

/**
 * @author WanChuanLai
 * @create 9/28/16.
 */
public class OrderDeliveryDTO {
    /**
     * 序列化版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 配送信息标识
     */
    private int id;
    /**
     *订单标识
     */
    private int orderId;
    /**
     *运费规则标识
     */
    private int freightRuleId;
    /**
     * 配送方式
     */
    private int deliveryModeId;

    /**
     * 配送方式名称
     */
    private String deliveryModeName;
    /**
     * 配送方式名称
     */
    private String deliveryModeNameEN;
    /**
     *物流单号
     */
    private String expressNumber;
    /**
     *物流公司标识
     */
    private int expressCompanyId;
    /**
     *物流公司名称
     */
    private String expressCompanyName;
    /**
     *收货人名称
     */
    private String receiverName;
    /**
     *所在地区
     */
    private int regionId;

    /**
     * 收货地区id拼接
     */
    private String regionIdPath;
    /**
     *所在地区名称
     */
    private String regionName;
    /**
     *详细地区
     */
    private String address;
    /**
     *手机号码
     */
    private String mobile;
    /**
     *固定电话
     */
    private String phone;
    /**
     *邮政编码
     */
    private String postcode;
    /**
     *收货人邮箱
     */
    private String email;

    /**
     * 发货时间
     */
    private Date sendTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFreightRuleId() {
        return freightRuleId;
    }

    public void setFreightRuleId(int freightRuleId) {
        this.freightRuleId = freightRuleId;
    }

    public int getDeliveryModeId() {
        return deliveryModeId;
    }

    public void setDeliveryModeId(int deliveryModeId) {
        this.deliveryModeId = deliveryModeId;
    }

    public String getDeliveryModeName() {
        return deliveryModeName;
    }

    public void setDeliveryModeName(String deliveryModeName) {
        this.deliveryModeName = deliveryModeName;
    }

    public String getDeliveryModeNameEN() {
        return deliveryModeNameEN;
    }

    public void setDeliveryModeNameEN(String deliveryModeNameEN) {
        this.deliveryModeNameEN = deliveryModeNameEN;
    }

    public String getExpressNumber() {
        return expressNumber;
    }

    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber;
    }

    public int getExpressCompanyId() {
        return expressCompanyId;
    }

    public void setExpressCompanyId(int expressCompanyId) {
        this.expressCompanyId = expressCompanyId;
    }

    public String getExpressCompanyName() {
        return expressCompanyName;
    }

    public void setExpressCompanyName(String expressCompanyName) {
        this.expressCompanyName = expressCompanyName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionIdPath() {
        return regionIdPath;
    }

    public void setRegionIdPath(String regionIdPath) {
        this.regionIdPath = regionIdPath;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
