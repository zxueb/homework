package pattern.builder;

/**
 *建造器模式
 * 创建对象过程更为灵活
 */
public class Person {
    private String name;
    private String sex;
    private Integer age;

    private Person(String name,String sex,Integer age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    @Override
    public String toString(){
        return "Kind{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
    public static class PersonBuilder{
        private String name;
        private String sex;
        private Integer age;

        public PersonBuilder name(String name){
            this.name = name;
            return this;
        }
        public PersonBuilder sex(String sex){
            this.sex = sex;
            return this;
        }
        public PersonBuilder age(Integer age){
            this.age = age;
            return this;
        }
        public Person build(){
            return new Person(this.name,this.sex,this.age);
        }
    }
}
