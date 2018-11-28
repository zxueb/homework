package pattern.abstractFactory.factory;

import pattern.abstractFactory.Product.Adjunct;
import pattern.abstractFactory.Product.Champion;
import pattern.abstractFactory.Product.Fire;
import pattern.abstractFactory.Product.Kind;

public class HeroYasa implements AbstractFactory{

    @Override
    public Adjunct createPerson() {
        return new Fire();
    }

    @Override
    public Kind createKind() {
        return new Champion();
    }
}
