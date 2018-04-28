package decorator.components;

/**
 * <p>2,在FlowerBouquet上面的类中，我们写了一个description实例变量，一个getDescription()返回它的方法和一个抽象cost()方法。接下来我们将编写ConcreteComponent类。</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年04月21日 18:31.
 */
public class RoseBouquet extends FlowerBouquet{

    public RoseBouquet(){
        description = "Rose bouquet";
    }
    public  double cost(){
        return 12.0;
    }
}