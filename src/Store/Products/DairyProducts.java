package Store.Products;

public class DairyProducts extends Product {

    public DairyProducts(int createDay) {
        super(createDay);
    }

    @Override
    protected String[] getProductTypeNames() {
        return new String[] {"Желе", "Сырок глазированный", "Сырок творожный", "Йогурт", "Простокваша", "Творог", "Сметана", "Сыр", "Молоко", "Кефир"};
    }

    @Override
    int price() {
        int maxPrice = 59;
        int minPrice = 39;
        return minPrice + (int) (Math.random() * maxPrice);
    }

    @Override
    protected int expirationDate() {
        int minDate = 1;
        int maxDate = 60;
        return minDate + (int) (Math.random() * maxDate);
    }
}
