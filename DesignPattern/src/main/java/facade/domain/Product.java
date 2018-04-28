package facade.domain;

/**
 * <p>类名注释</br>类的用途</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年04月28日 09:30.
 */
public class Product {
    public int productId;
    public String name;
    public Product(){}
    public Product(int productId, String name){
        this.productId=productId;
        this.name=name;
    }
}
