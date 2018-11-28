package pattern.flyweight;

/**
 * 享元模式
 * 提倡重用已有对象，而不是创建新的对象
 */
public class TestFlyweight {
    public static void main(String[] args){
        System.out.println(Integer.valueOf(2) == Integer.valueOf(2));
        System.out.println(Integer.valueOf(200) == Integer.valueOf(200));
//        System.out.println(Integer.valueOf(200).equals(Integer.valueOf(200)));
    }
}
