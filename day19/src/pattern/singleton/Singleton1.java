package pattern.singleton;
/**
 * 恶汉式单例
 * 一开始创建好，等别人来调用
 */

class Singleton1 {
    //构造方法私有
    private Singleton1(){
    }
    //创建实例
    private static final Singleton1 ME = new Singleton1();
    //获取唯一实例
    public static Singleton1 getInstance(){
        return ME;
    }

}
