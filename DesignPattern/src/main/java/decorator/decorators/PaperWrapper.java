package decorator.decorators;

import decorator.components.FlowerBouquet;

/**
 * <p>5,我们扩展了这个Glitter类FlowerDecorator，并添加了一个FlowerBouquet实例变量（Composition）来容纳我们正在包装的花束。实例变量在运行时通过构造函数调用进行初始化。然后我们实现了这个getDescription()方法，并返回了这个装饰器的描述和它正在装饰的花束。我们也实施了这种cost()方法来将这个装饰者的花费加到它正在装饰的花束的花费上。我们将类似地编写其他装饰器类</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年04月21日 18:36.
 */
public class PaperWrapper extends FlowerBouquetDecorator{

    FlowerBouquet flowerBouquet;
    public PaperWrapper(FlowerBouquet flowerBouquet){
        this.flowerBouquet=flowerBouquet;
    }
    public  String getDescription(){
        return flowerBouquet.getDescription()+", paper wrap";
    }
    public double cost()
    {
        return 3+flowerBouquet.cost();
    }
}