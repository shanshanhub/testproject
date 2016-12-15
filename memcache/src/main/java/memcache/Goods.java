package memcache;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author WanChuanLai
 * @create 12/6/16.
 */
public class Goods implements Serializable {
    /**
     * 主键ID
     */
    private int id;

    /**
     * 分站ID
     */
    private int subSiteId;

    /**
     * 邮包分站ID
     */
    private String eShopSubsiteId;

    /**
     * 商品ID
     */
    private int productId;

    /**
     * 商品款式ID
     */
    private int productStyleId;

    /**
     * 实际库存
     */
    private int stock;

    /**
     * 限制库存
     */
    private int limitStock;

    /**
     * 销售价
     */
    private BigDecimal salesPrice;

    /**
     * 成本价
     */
    private BigDecimal costPrice;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 上下架状态
     */
    private int shelfStatus;

    /**
     * 上下架时间
     */
    private Date shelfTime;

    /**
     * 积分
     */
    private int points;

    /**
     * 初始销量
     */
    private int initSalesVolume;

    /**
     * 是否默认
     */
    private boolean isDefault;


    private Date createTime;

    /**
     * 创建人
     */

    private int createUser;

    /**
     * 最后修改时间
     */
    private Date lastModifyTime;

    /**
     * 最后修改人
     */
    private int lastModifyUser;

    /**
     * 状态
     */
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubSiteId() {
        return subSiteId;
    }

    public void setSubSiteId(int subSiteId) {
        this.subSiteId = subSiteId;
    }

    public String geteShopSubsiteId() {
        return eShopSubsiteId;
    }

    public void seteShopSubsiteId(String eShopSubsiteId) {
        this.eShopSubsiteId = eShopSubsiteId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductStyleId() {
        return productStyleId;
    }

    public void setProductStyleId(int productStyleId) {
        this.productStyleId = productStyleId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getLimitStock() {
        return limitStock;
    }

    public void setLimitStock(int limitStock) {
        this.limitStock = limitStock;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public int getShelfStatus() {
        return shelfStatus;
    }

    public void setShelfStatus(int shelfStatus) {
        this.shelfStatus = shelfStatus;
    }

    public Date getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(Date shelfTime) {
        this.shelfTime = shelfTime;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getInitSalesVolume() {
        return initSalesVolume;
    }

    public void setInitSalesVolume(int initSalesVolume) {
        this.initSalesVolume = initSalesVolume;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCreateUser() {
        return createUser;
    }

    public void setCreateUser(int createUser) {
        this.createUser = createUser;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public int getLastModifyUser() {
        return lastModifyUser;
    }

    public void setLastModifyUser(int lastModifyUser) {
        this.lastModifyUser = lastModifyUser;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Goods(int id, int subSiteId, String eShopSubsiteId, int productId, int productStyleId, int stock, int limitStock, BigDecimal salesPrice, BigDecimal costPrice, BigDecimal marketPrice, int shelfStatus, Date shelfTime, int points, int initSalesVolume, boolean isDefault, Date createTime, int createUser, Date lastModifyTime, int lastModifyUser, int status) {
        this.id = id;
        this.subSiteId = subSiteId;
        this.eShopSubsiteId = eShopSubsiteId;
        this.productId = productId;
        this.productStyleId = productStyleId;
        this.stock = stock;
        this.limitStock = limitStock;
        this.salesPrice = salesPrice;
        this.costPrice = costPrice;
        this.marketPrice = marketPrice;
        this.shelfStatus = shelfStatus;
        this.shelfTime = shelfTime;
        this.points = points;
        this.initSalesVolume = initSalesVolume;
        this.isDefault = isDefault;
        this.createTime = createTime;
        this.createUser = createUser;
        this.lastModifyTime = lastModifyTime;
        this.lastModifyUser = lastModifyUser;
        this.status = status;
    }
}
