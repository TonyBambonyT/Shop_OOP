package Buyer;

import Store.*;
import Store.Products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Buyer {
    int money;
    boolean discountCard;
    private final List<Wish> wishList = new ArrayList<>();
    protected Random random = new Random();

    record Wish(ProductType type, int num){};

    public Buyer() {
        money = getStartMoney();
        discountCard = Math.random() > 0.5;

        wishList.addAll(getWishList());

    }

    public abstract int getStartMoney();

    public abstract List<Wish> getWishList();

    public record ResultOfBuying(List<Product> products, int wastedMoney){
        @Override
        public String toString() {
            return products.toString() + "\n" + "потрачено: " + wastedMoney + "₽";
        }
    }
    public ResultOfBuying buy(Store store){
        List<Product> products = new ArrayList<>();
        int wastedMoney = 0;

        List<Wish> remainWishes = new ArrayList<>();

        for (Wish wish : wishList) {
            Store.ChequeItem buyed = store.buy(wish.type, wish.num, money, discountCard);
            if(buyed == null) {
                remainWishes.add(wish);
                continue;
            }

            money -= buyed.price();
            products.add(buyed.product());
            wastedMoney += buyed.price();
        }

        wishList.clear();
        wishList.addAll(remainWishes);

        return new ResultOfBuying(products, wastedMoney);
    }

    public void addNewWishes(){
        wishList.addAll(getWishList());
    }

    @Override
    public String toString() {
        String str = "";
        str += "денег " + money + "₽ Дисконтн:" + discountCard + "\n";
        str += "хочу купить: ";
        for (Wish wish: wishList){
            str += Store.getTypes(wish.type)[wish.num] + ", ";
        }
        return str;
    }
}
