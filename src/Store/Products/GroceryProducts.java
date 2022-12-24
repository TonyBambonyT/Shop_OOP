package Store.Products;

public class GroceryProducts extends Product {
    public GroceryProducts(int createDay) {
        super(createDay);
    }

    @Override
    protected String[] getProductTypeNames() {
        return new String[] {"Мюсли", "Мука блинная", "Чечевица Зелёная целая", "Масло горчичное", "Фасоль белая", "Разрыхлитель теста", "Макароны"};
    }

    @Override
    int price() {
        int maxPrice = 88;
        int minPrice = 69;
        return minPrice + (int) (Math.random() * maxPrice);
    }

    @Override
    protected int expirationDate() {
        int minDate = 1;
        int maxDate = 30;
        return minDate + (int) (Math.random() * maxDate);
    }
}