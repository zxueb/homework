package pattern.builder;

public class Test {
    public static void main(String[] args){
        Person p = new Person.PersonBuilder()
                .name("zhangsan")
                .sex("男")
                .age(12)
                .build();
        System.out.println(p.toString());
    }
}
