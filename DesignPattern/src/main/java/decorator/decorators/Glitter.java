package decorator.decorators;

import decorator.components.FlowerBouquet;

/**
 * <p>4,我们将这个FlowerDecorator类扩展FlowerBouquet并声明了一个抽象getDescription()方法。我们这样做是因为我们希望我们所有的花装饰类实现getDescription()，包括装饰者的描述和装饰的花束。一旦我们编写ConcreteDecorator类，这将变得更加清晰。让我们开始吧Glitter。</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年04月21日 18:34.
 */
public class Glitter extends FlowerBouquetDecorator {
    FlowerBouquet flowerBouquet;

    public Glitter(FlowerBouquet flowerBouquet) {
        this.flowerBouquet = flowerBouquet;
    }

    public String getDescription() {
        return flowerBouquet.getDescription() + ", glitter";
    }

    public double cost() {
        return 4 + flowerBouquet.cost();
    }
}
