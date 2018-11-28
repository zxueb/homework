package enumPractice;

public class Test {
    public static void main(String[] args){
        //获取枚举对象序号，ordinal（）方法
        System.out.printf("%d\n",Sex.MALE.ordinal());
        System.out.printf("%d\n",Sex.FEMALE.ordinal());
        //把枚举对象转为字符串
        System.out.println(Sex.MALE.name());
        //把字符串转为枚举对象
        System.out.println(Sex.valueOf("MALE"));
        //打印所有的枚举对象
        for(Sex value : Sex.values()){
            System.out.println(value);
        }
        System.out.println(Sex.MALE.cnName());
        System.out.println(Sex.FEMALE.cnName());
    }
}
