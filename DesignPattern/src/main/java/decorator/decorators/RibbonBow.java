package decorator.decorators;

import decorator.components.FlowerBouquet;

/**
 * <p>类名注释</br>类的用途</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年04月21日 18:36.
 */
public class RibbonBow extends FlowerBouquetDecorator {
    FlowerBouquet flowerBouquet;

    public RibbonBow(FlowerBouquet flowerBouquet) {
        this.flowerBouquet = flowerBouquet;
    }

    public String getDescription() {
        return flowerBouquet.getDescription() + ", ribbon bow";
    }

    public double cost() {
        return 6.5 + flowerBouquet.cost();
    }
}