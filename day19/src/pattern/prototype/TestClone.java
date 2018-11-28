package pattern.prototype;

import java.util.Date;

/**
 * 原型模式
 * 根据已有对象来创建新的对象
 */
public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
//        User user = new User();
//        user.setName("zhangsan");
//        user.setAge(15);
//
//        User user2 = (User) user.clone();
//        System.out.println(user == user2);
//        System.out.println(user2.getAge());
//        System.out.println(user2.getName());
//        System.out.println("----------------------");
        User2 user21 = new User2();
        user21.setAge(45);
        user21.setName("wangwu");
        user21.setBirthday(new Date());

        User2 user22 = (User2) user21.clone();
        System.out.println(user22.getName());
        System.out.println(user22.getAge());
        user22.getBirthday().setDate(29);
        System.out.println("clone" + user22.getBirthday());
        System.out.println("wangwu" + user21.getBirthday());
    }
}
