package pattern.abstractFactory.factory;

import pattern.abstractFactory.Product.Kind;
import pattern.abstractFactory.Product.Adjunct;

public interface AbstractFactory {
    public Adjunct createPerson();
    public Kind createKind();
}
