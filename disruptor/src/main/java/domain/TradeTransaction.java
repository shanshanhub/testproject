package domain;

/**
 * @author WanChuanLai
 * @create 8/8/16.
 * 作用:交易类PO
 */
public class TradeTransaction {
    private String id;//交易id
    private double price;//交易金额
    public TradeTransaction(){

    }

    public TradeTransaction(String id, double price) {
        this.id = id;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TradeTransaction{" +
                "id='" + id + '\'' +
                ", price=" + price +
                '}';
    }
}
