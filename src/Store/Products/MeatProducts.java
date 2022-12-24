package Store.Products;

public class MeatProducts extends Product {
    public MeatProducts(int createDay) {
        super(createDay);
    }

    @Override
    protected String[] getProductTypeNames() {
        return new String[] {"Куриные крокеты в панировке", "Грудинка мясная", "Бекон", "Колбаса", "Сосиски", "Ветчина",
                "Паштет", "Карбонат", "Поджарка из свинины", "Шницель из свинины"};
    }

    @Override
    int price() {
        int maxPrice = 229;
        int minPrice = 114;
        return minPrice + (int) (Math.random() * maxPrice);
    }


    @Override
    protected int expirationDate() {
        int minDate = 1;
        int maxDate = 10;
        return minDate + (int) (Math.random() * maxDate);
    }
}

