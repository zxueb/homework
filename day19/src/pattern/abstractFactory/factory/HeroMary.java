package pattern.abstractFactory.factory;

import pattern.abstractFactory.Product.Kind;
import pattern.abstractFactory.Product.Water;
import pattern.abstractFactory.Product.Adjunct;
import pattern.abstractFactory.Product.Champion;
public class HeroMary implements AbstractFactory{
    @Override
    public Adjunct createPerson() {
        return new Water();
    }

    @Override
    public Kind createKind() {
        return new Champion();
    }
}
