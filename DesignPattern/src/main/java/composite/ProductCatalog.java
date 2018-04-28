package composite;

import java.util.ArrayList;

/**
 * <p>类名注释</br>类的用途</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年04月15日 20:48.
 */
public class ProductCatalog extends CatalogComponent {
    private ArrayList<CatalogComponent> items = new ArrayList<CatalogComponent>();
    private String name;

    public ProductCatalog(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        for (CatalogComponent comp : items) {
            comp.print();
        }
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        items.remove(catalogComponent);
    }
}
