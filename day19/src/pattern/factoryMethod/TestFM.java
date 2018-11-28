package pattern.factoryMethod;

public class TestFM {
    public static void main(String[] args){
        CatFactory cf = new CatFactory();
        Cat cat = (Cat) cf.creatAnimal();
        cat.eat();
        DogFactory df = new DogFactory();
        Dog dog = (Dog) df.creatAnimal();
        dog.eat();
    }
}
