package pattern.singleton;

public class TestSingleton {
    public static void main(String[] args){
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        Singleton2 s3 = Singleton2.getInstance();
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        Singleton3.getInstance();
        Singleton3.getInstance();
        Singleton3.test();


    }
}
