package pattern.singleton;

/**
 *懒汉式更佳实现
 */
public class Singleton3 {
    static {
        System.out.println("Singleton3加载了");
    }
    private Singleton3(){
    }
    private static class Holder{
        static{
            System.out.println("Holder加载了");
        }
        static Singleton3 ME = new Singleton3();
    }
    public static Singleton3 getInstance(){
        return Holder.ME;
    }
    public static void test() {
        System.out.println("Singleton3其它方法");
    }
}
