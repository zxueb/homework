package pattern.abstractFactory.Product;

public class Water implements Adjunct {
    @Override
    public void adjunct() {
        System.out.println("属性为火");
    }
}
