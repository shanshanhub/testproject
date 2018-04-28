package composite;

/**
 * <p>类名注释</br>类的用途</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年04月15日 20:52.
 */
public class CatalogComponentTest {
    public static void main(String[] args) {
          /*Create primary products for main catalog*/
        CatalogComponent mJeanProduct = new Product("M: Jeans 32", 65.00);
        CatalogComponent mTShirtProduct = new Product("M: T Shirt 38", 45.00);

        /*Create a composite product catalog and add female products to it*/
        CatalogComponent newCatalog = new ProductCatalog("Female Products");
        CatalogComponent fJeans = new Product("F: Jeans 32", 65.00);
        CatalogComponent fTShirts = new Product("F: T Shirt 38", 45.00);
        newCatalog.add(fJeans);
        newCatalog.add(fTShirts);

       /*Create a composite product catalog and add kid products to it*/
        CatalogComponent kidCatalog = new ProductCatalog("Kids Products");
        CatalogComponent kidShorts = new Product("Return Gift", 23.00);
        CatalogComponent kidPlayGears = new Product("Summer Play Gear", 65.00);
        kidCatalog.add(kidShorts);
        kidCatalog.add(kidPlayGears);

        /*Create primary catalog and add primary products and new catalogs to it*/
        CatalogComponent mainCatalog = new ProductCatalog("Primary Catalog");
        mainCatalog.add(mJeanProduct);
        mainCatalog.add(mTShirtProduct);
        mainCatalog.add(newCatalog);
        mainCatalog.add(kidCatalog);

        /*Print out product/catalog information*/
        mainCatalog.print();
    }
}
