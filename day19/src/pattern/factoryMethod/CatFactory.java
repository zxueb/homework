package pattern.factoryMethod;

public class CatFactory implements AnimalFactory{
    @Override
    public Animal creatAnimal(){
        return new Cat();
    }
}
