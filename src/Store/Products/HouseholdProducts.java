package Store.Products;

public class HouseholdProducts extends Product {

    public HouseholdProducts(int createDay) {
        super(createDay);
    }

    @Override
    protected String[] getProductTypeNames() {
        return new String[]{"Средство для мытья посуды", "Чистящее средство", "Гель капсулы", "Стиральный порошок", "Гель для стирки", "Капсулы для стирки", "Кондиционер для белья"};

    }

    @Override
    int price() {
        int maxPrice = 129;
        int minPrice = 99;
        return minPrice + (int) (Math.random() * maxPrice);
    }

    @Override
    protected int expirationDate() {
        int minDate = 1;
        int maxDate = 730;
        return minDate + (int) (Math.random() * maxDate);
    }
}
