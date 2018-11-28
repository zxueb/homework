package pattern.abstractFactory.factory;

import pattern.abstractFactory.Product.Fire;
import pattern.abstractFactory.Product.Kind;
import pattern.abstractFactory.Product.Adjunct;
import pattern.abstractFactory.Product.Shooter;

public class HeroAnny implements AbstractFactory {
    @Override
    public Adjunct createPerson() {
        return new Fire();
    }

    @Override
    public Kind createKind() {
        return new Shooter();
    }
}
