package Store;

import Store.Products.Product;

/**
 * class, that stores products and discount
 */
public class ProductWithDiscount {
    public final Product product;

    private int leaving;

    public ProductWithDiscount(Product product) {
        this.product = product;
        leaving = 100;
    }

    public int getPrice(){
        return product.price * leaving / 100;
    }

    void discount(int percent){
        if(percent > 100 || percent < 0) throw new IllegalArgumentException();
        leaving = leaving * (100-percent) / 100;
    }


    @Override
    public String toString(){
        return  "{" + product.name +
                " цена:" + getPrice() + "₽" +
                " годен до:" + product.sellBy()  +
                " код:" + product.numOfType +
                " скидка:" + (100 - leaving) + "% " + "}";

    }

    public int getPercentDiscount() {
        return 100 - leaving;
    }
}
