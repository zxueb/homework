package pattern.singleton;

/**
 * 懒汉式单例
 * 用到时创建，用不到不创建
 *
 */
public class Singleton2 {
    private Singleton2(){

    }
    private static Singleton2 ME;

    /**
     * 获取Singleton2对象
     * 当第一次调用时ME == null为真，后续就不会创建对象
     * 多线程下为了保证，需要sychronized同步
     * @return
     */
    public static synchronized Singleton2 getInstance(){
        if(ME == null){
            ME = new Singleton2();
        }
        return ME;
    }

}
