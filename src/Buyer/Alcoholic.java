package Buyer;

import Store.*;

import java.util.ArrayList;
import java.util.List;

public class Alcoholic extends Buyer{
    @Override
    public int getStartMoney() {
        return 5000;
    }

    @Override
    public List<Wish> getWishList() {
        List<Wish> wishList = new ArrayList<>();
        // только алкоголь
        ProductType type = ProductType.AlcoholicProducts;
        for (int i = 0; i < 3; i++) {
            wishList.add(new Wish(type, random.nextInt(Store.getTypes(type).length)));
        }
        return wishList;
    }
}
