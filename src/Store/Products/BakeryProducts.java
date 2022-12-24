package Store.Products;

public class BakeryProducts extends Product {

    public BakeryProducts(int createDay) {
        super(createDay);
    }

    @Override
    protected String[] getProductTypeNames() {
        return new String[] {"Булочка 'Чико' с чесночной начинкой", "Палочка 'Гриссини премиум' с отд паприкой",
                "Пирог с начинкой из капусты", "Слойка с вишнёвой начинкой", "Пирожок печёный с вишней",
                "Булочка с грушёвой начинкой", "Дениш с абрикосом и творогом", "Булочка для гамбургеров", "Пирог с ягодами",
                "Шницель из свинины"};
    }

    @Override
    int price() {
        int maxPrice = 13;
        int minPrice = 10;
        return minPrice + (int) (Math.random() * maxPrice);
    }

    @Override
    protected int expirationDate() {
        int minDate = 1;
        int maxDate = 2;
        return minDate + (int) (Math.random() * maxDate);
    }
}
