import java.util.Comparator;

public class MyComparator {

    Comparator<ShopProduct> compareShopProduct = new Comparator<ShopProduct>() {
        @Override
        public int compare(ShopProduct o1, ShopProduct o2) {
            return 0;
        }
    };

    public void compareProduct(ProductList productList) {
        for (ShopProduct shopProduct : productList.productArrayList) {
            compareShopProduct.thenComparingDouble(ShopProduct::getRating).thenComparing(Comparator.comparingInt(ShopProduct::getRating));
        }
    }
}
