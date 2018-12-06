package treasure;

import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestTreasure {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        // 类加载器, 作用：加载一个不在classpath下的类
        ClassLoader cl = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    FileInputStream in  = new FileInputStream("C:\\Users\\Administrator\\Desktop\\Treasure.class");
                    byte[] bytes = new byte[1024*8];
                    int len = in.read(bytes);

                    // 调用父类的方法根据字节数组加载类
                    return defineClass(name, bytes, 0, len);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };

        Class<?> clazz1 = cl.loadClass("com.westos.Treasure");
// 根据类名加载类, 得到类对象
        Constructor<?> cons = clazz1.getDeclaredConstructor();
        cons.setAccessible(true);
        Method[] methods = clazz1.getDeclaredMethods();
        //返回带注释的方法
        for(Method m : methods){
            Annotation[] at = m.getDeclaredAnnotations();
            for(Annotation a:at){
                System.out.println("注释：");
                System.out.println(a.toString());
            }
            System.out.println("方法+" + m);
        }

        for(int j = 13;j<16;j++){
            methods[j].invoke(cons.newInstance());
        }
        System.out.println(methods[15].getName());
//        mbea0e4d50f584e0cb01c836bc14369f1


//        Class<?> clazz = cl.loadClass("com.westos.Treasure"); // 根据类名加载类, 得到类对象
//        Constructor<?> con = clazz.getDeclaredConstructor();
//        con.setAccessible(true);
//        Object obj = con.newInstance();
//        Arrays.stream(clazz.getDeclaredMethods()).filter(m -> m.getAnnotations().length > 0).findFirst().ifPresent((method) -> {
//            try {
//                method.invoke(obj);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        });




    }
}
