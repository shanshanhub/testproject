package composite;

/**
 * <p>类名注释</br>类的用途</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年04月15日 20:48.
 */
public class Product extends CatalogComponent {
    private String name;
    private double price;
    public Product (String name, double price){
        this.name=name;
        this.price=price;
    }

    @Override
    public String getName() {
        return  this.name;
    }


    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void print(){
        System.out.println("Product name: "+name+" Price: "+price);
    }
}
