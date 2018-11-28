package pattern.abstractFactory.Product;

public class Champion implements Kind {
    @Override
    public void skill() {

        System.out.println("近身攻击" );
    }
}
