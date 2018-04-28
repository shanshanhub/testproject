package decorator.components;

/**
 * <p>1,为了将装饰器模式应用于花束示例，我们来编写抽象基类Component。</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年04月21日 18:28.
 */
public abstract class FlowerBouquet {
    String description;
    public String getDescription() {
        return description;
    }
    public abstract double cost();
}