import Buyer.*;
import Store.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Main {
    enum EventType{
        DELIVERY_IN_WAREHOUSE,
        MOVE_TO_SHOPPING_ROOM,
        REMOVE_EXPIRED_PRODUCT,
        BUY,
        DISCOUNT
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.deliveryInWarehouse(10);
        store.moveToShoppingRoom();
        System.out.println("товары на открытии");
        System.out.println(store.getProducts());

        List<Buyer> buyers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            buyers.add(new NormalPeople());
        }
        buyers.add(new Alcoholic());

        int days = 30;
        for (int i = 0; i < days; i++) {
            System.out.println("--------------день: " + store.getNowDay());
            int events = (int) (Math.random() * 7) + 3;

            for (int j = 0; j < events; j++) {
                Random random = new Random();
                // generate event
                int num = random.nextInt(EventType.values().length);
                EventType eventType = EventType.values()[num];

                switch (eventType) {
                    case DELIVERY_IN_WAREHOUSE -> {
                        System.out.println("доставка на склад новых продуктов, новые продукты:");
                        System.out.println(store.deliveryInWarehouse(2));
                    }
                    case MOVE_TO_SHOPPING_ROOM -> {
                        System.out.println("перемещение продуктов со скада в зал, новые продукты в зале");
                        System.out.println(store.moveToShoppingRoom());
                    }
                    case REMOVE_EXPIRED_PRODUCT -> {
                        System.out.println("удаление всех просроченных продуктов, удалили:");
                        System.out.println(store.removeExpiredProduct());
                    }
                    case BUY -> {
                        System.out.println("заходит покупатель в магазин, и покупает:");
                        Buyer buyer = buyers.get(random.nextInt(buyers.size()));
                        buyer.addNewWishes();
                        System.out.println(buyer);
                        Buyer.ResultOfBuying res = buyer.buy(store);
                        System.out.println("купил");
                        System.out.println(res);
                        System.out.println("теперь");
                        System.out.println(buyer);
                    }

                    case DISCOUNT -> {
                        System.out.println("делаем скидку на продукты близкие к просрочке, сделали на");
                        System.out.println(store.discountProduct());

                    }
                }
                System.out.println();
            }
            System.out.println("на конец дня в зале");
            System.out.println(store.getProducts());
            System.out.println();
            store.nextDay();
        }


    }
}