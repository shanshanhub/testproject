package decorator;

import decorator.components.FlowerBouquet;
import decorator.components.OrchidBouquet;
import decorator.components.RoseBouquet;
import decorator.decorators.Glitter;
import decorator.decorators.PaperWrapper;
import decorator.decorators.RibbonBow;

/**
 * <p>7,在上面测试类的第13行 - 第15行中，我们首先实例化a RoseBouquet并打印其描述和成本。
 * 在第18行-第23行，我们再次实例化的RoseBouquet，而这一次，我们用它包裹着PaperWrapper，RibbonBow和Glitter装饰印刷其描述和价格之前。
 * 在第26行 - 第31行中，我们实例化了a OrchidBouquet，并在打印其描述和成本之前将其包装两次，PaperWrapper然后一次RibbonBow。</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年04月21日 18:38.
 */
public class Test {
    public static void main(String [] args){
        /*Rose bouquet with no decoration*/
        FlowerBouquet roseBouquet = new RoseBouquet();
        System.out.println(roseBouquet.getDescription()
                + " $ " + roseBouquet.cost());

         /*Rose bouquet with paper wrapper, ribbon bow, and glitter*/
        FlowerBouquet decoratedRoseBouquet = new RoseBouquet();
        decoratedRoseBouquet=new PaperWrapper(decoratedRoseBouquet);
        decoratedRoseBouquet=new RibbonBow(decoratedRoseBouquet);
        decoratedRoseBouquet=new Glitter(decoratedRoseBouquet);
        System.out.println(decoratedRoseBouquet.getDescription()
                + " $ " + decoratedRoseBouquet.cost());

         /*Orchid bouquet with double paper wrapper and ribbon bow*/
        FlowerBouquet decoratedOrchidBouquet = new OrchidBouquet();
        decoratedOrchidBouquet=new PaperWrapper(decoratedOrchidBouquet);
        decoratedOrchidBouquet=new PaperWrapper(decoratedOrchidBouquet);
        decoratedOrchidBouquet=new RibbonBow(decoratedOrchidBouquet);
        System.out.println(decoratedOrchidBouquet.getDescription()
                + " $ " + decoratedOrchidBouquet.cost());
    }
}
