package pattern.factoryMethod;



public class DogFactory implements AnimalFactory {
    @Override
    public Animal creatAnimal(){
        return new Dog();
    }
}
