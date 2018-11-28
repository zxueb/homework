package pattern.simpleFactory;

public class TestSimpleFactory {
    public static void main(String[] args){
        Dog dog = (Dog) AnimalFactory.creatAnimal("dog");
        dog.eat();
        Cat cat = (Cat) AnimalFactory.creatAnimal("cat");
        cat.eat();
    }


}
