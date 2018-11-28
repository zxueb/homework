package pattern.abstractFactory.Product;

public class Shooter implements Kind {
    @Override
    public void skill() {
        System.out.println("远程攻击");
    }
}
