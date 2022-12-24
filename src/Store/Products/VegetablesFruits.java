package Store.Products;

public class VegetablesFruits extends Product {

    public VegetablesFruits(int createDay) {
        super(createDay);
    }

    @Override
    protected String[] getProductTypeNames() {
        return new String[] {"Манго", "Сельдерей стебель", "Клюква", "Яблоки Гала", "Чурчхела с фундуком", "Зелень ассорти лук, укроп, петрушка", "Томаты сливовидные", "Шампиньоны резанные", "Финики", "Картофель мытый экстра"};
    }

    @Override
    int price() {
        int maxPrice = 159;
        int minPrice = 71;
        return minPrice + (int) (Math.random() * maxPrice);
    }

    @Override
    protected int expirationDate() {
        int minDate = 1;
        int maxDate = 30;
        return minDate + (int) (Math.random() * maxDate);
    }
}