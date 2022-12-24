package Buyer;

import Store.*;

import java.util.ArrayList;
import java.util.List;

public class NormalPeople extends Buyer {

    @Override
    public int getStartMoney() {
        int maxMoney = 10000;
        int minMoney = 100;
        return minMoney + (int) (Math.random() * maxMoney);
    }

    @Override
    public List<Wish> getWishList() {
        List<Wish> wishList = new ArrayList<>();
        // всего понемногу
        for (ProductType type : ProductType.values()) {
            wishList.add(new Wish(type, random.nextInt(Store.getTypes(type).length)));
        }
        return wishList;
    }
}
