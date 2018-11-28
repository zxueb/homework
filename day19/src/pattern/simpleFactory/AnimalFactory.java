package pattern.simpleFactory;

public interface AnimalFactory {
//    public static Dog createDog(){
//        return new Dog();
//    }
//    public static Cat createCat(){
//        return new Cat();
//    }
    public static Animal creatAnimal(String name){
        if(name.equals("dog")){
            return new Dog();
        }else if(name.equals("cat")){
            return new Cat();
        }else{
            return null;
        }
    }
}
