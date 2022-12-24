package Store.Products;

public class CigaretteProducts extends Product {

    public CigaretteProducts(int createDay) {
        super(createDay);
    }

    @Override
    protected String[] getProductTypeNames() {
        return new String[] {"Чапман", "Мальборо", "Винстон", "Беламор", "Собрание", "Данхилл"};
    }

    @Override
    int price() {
        int maxPrice = 180;
        int minPrice = 150;
        return minPrice + (int) (Math.random() * maxPrice);
    }

    @Override
    protected int expirationDate() {
        int minDate = 1;
        int maxDate = 120;
        return minDate + (int) (Math.random() * maxDate);
    }
}
