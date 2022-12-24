package Store.Products;

public abstract class Product {
    public final String name;

    public final int price;
    public final Integer expirationDate;
    public final int numOfType;

    public final int createDay;

    protected abstract String[] getProductTypeNames();

    abstract int price();

    abstract int expirationDate();

    public String[] getTypes(){
        return getProductTypeNames();
    }

    public Product(int createDay){
        numOfType = (int) (Math.random() * getTypes().length);
        name = getProductTypeNames()[numOfType];
        price = price();
        expirationDate = expirationDate();
        this.createDay = createDay;


    }

    @Override
    public  String toString(){
        return "{" + name + " базовая цена: " + price + "₽" + " годен до: " + sellBy() + " код: " + numOfType + "}";
    }

    public boolean isExpired(int nowDay){
        if(!canExpire()) return false;
        return nowDay > sellBy();
    }

    public boolean canExpire(){
        return expirationDate != null;
    }

    public Integer sellBy(){
        if(!canExpire()) return null;
        else return expirationDate + createDay;
    }
}
