package Store.Products;

public class AlcoholicProducts extends Product {
    static String[] types = new String[] {"Сидр", "Пиво св фил паст 4,6%", "Коктейль", "Коньяк", "Водка", "Вино"};

    public AlcoholicProducts(int createDay) {
        super(createDay);
    }

    @Override
    protected String[] getProductTypeNames() {
        return types;
    }

    @Override
    int price() {
        int maxPrice = 72;
        int minPrice = 59;
        return minPrice + (int) (Math.random() * maxPrice);
    }

    @Override
    protected int expirationDate() {
        int minDate = 1;
        int maxDate = 180;
        return minDate + (int) (Math.random() * maxDate);
    }
}