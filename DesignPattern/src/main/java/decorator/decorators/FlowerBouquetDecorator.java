package decorator.decorators;

import decorator.components.FlowerBouquet;

/**
 * <p>3,我们扩展了上面的两个类，FlowerBouquet并description在其构造函数中初始化变量。我们还在cost()每个课程中实施该方法以返回其成本。现在我们已经编写了组件，我们将编写装饰器。</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年04月21日 18:33.
 */
public abstract class FlowerBouquetDecorator extends FlowerBouquet {
    public abstract String getDescription();
}
