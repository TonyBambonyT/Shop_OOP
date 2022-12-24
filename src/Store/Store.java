package Store;

import Store.Products.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {
    Warehouse storeWarehouse = new Warehouse();
    List<ProductWithDiscount> products = new ArrayList<>();

    public final int discountK;

    public Store() {
        discountK = (int) (Math.random() * 20) + 10;
    }

    public int getNowDay() {
        return nowDay;
    }

    private int nowDay = 0;

    /**
     * generate and add products on warehouse
     * @return result - unmodifiable list of new products in warehouse
     */
    public List<Product> deliveryInWarehouse(int maxAmount){
        return storeWarehouse.delivery(nowDay, maxAmount);
    }

    /**
     * move all products from warehouse to shopping room
     * @return result - unmodifiable list of new products in shopping room
     */
    public List<Product> moveToShoppingRoom(){
        List<Product> productsFromWarehouse = storeWarehouse.takeProducts();
        products.addAll(productsFromWarehouse.stream().map(product -> new ProductWithDiscount(product)).toList());
        return Collections.unmodifiableList(productsFromWarehouse);
    }

    /**
     * remove all expired products
     * @return result - list of removed products
     */
    public List<Product> removeExpiredProduct(){
        List<Product> expired = new ArrayList<>();
        for (int i = products.size() - 1; i >= 0; i--) {
            Product product = products.get(i).product;
            if(product.isExpired(nowDay)) {
                products.remove(i);
                expired.add(product);
            }
        }
        return expired;
    }
    /**
     * remove all expired products
     * @return result - list of discounted products with his discounts
     */
    public List<ProductWithDiscount> discountProduct(){
        List<ProductWithDiscount> discounted = new ArrayList<>();

        for (ProductWithDiscount disProduct : products) {
            Product product = disProduct.product;
            if (!product.canExpire()) continue;
            if (nowDay + 2 > product.sellBy()) {
                if(disProduct.getPercentDiscount() < 90) disProduct.discount(30);
                discounted.add(disProduct);
            }
        }

        return discounted;
    }

    public void nextDay(){
        nowDay++;
    }

    public record ChequeItem(Product product, int price) {}

    public ChequeItem buy(ProductType type, int codeInType, int maxMoney, boolean discount){
        for (int i = 0; i < products.size(); i++) {
            ProductWithDiscount disProduct = products.get(i);
            Product product = disProduct.product;

            if(product.getClass() == type.toClass() &&
                    product.numOfType == codeInType &&
                    disProduct.getPrice() < maxMoney) {

                products.remove(i);
                if(discount) disProduct.discount(discountK);
                return new ChequeItem(product, disProduct.getPrice());
            }
        }
        return null;
    }

    public static String[] getTypes(ProductType type) {
        return Warehouse.getTypes(type);
    }


    public List<ProductWithDiscount> getProducts() {
        return Collections.unmodifiableList(products);
    }

}
