package Store;

import Store.Products.Product;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Warehouse {
    private List<Product> products = new ArrayList<>();

    /**
     * generate and add products on warehouse
     * @param nowDay day of generate
     * @return result - unmodifiable list of new products
     */
    List<Product> delivery(int nowDay, int maxAmount){
        List<Product> newProducts = new ArrayList<>();
        for (ProductType type: ProductType.values()) {
            newProducts.addAll(createAndDelivery(type, (int) (Math.random() * (maxAmount+1)), nowDay));
        }
        products.addAll(newProducts);
        return Collections.unmodifiableList(newProducts);
    }

    /**
     * remove all products from warehouse and return it
     * @return all warehouse products
     */
    List<Product> takeProducts(){
        List<Product> all = Collections.unmodifiableList(products);
        products = new ArrayList<>();
        return all;
    }

    private static List<Product> createAndDelivery(ProductType productType, int numberProducts, int nowDay){
        List<Product> courier = new ArrayList<>();
        for (int i = 0; i < numberProducts; i++) {
            courier.add(createProduct(productType, nowDay));
        }
        return courier;
    }

    private static Product createProduct(ProductType type, int nowDay) {
        try {
            return type.toClass().getDeclaredConstructor(int.class).newInstance(nowDay);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalArgumentException("illegal type");
        }
    }

    public static String[] getTypes(ProductType type) {
        return createProduct(type, 0).getTypes();
    }



}
