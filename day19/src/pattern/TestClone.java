package com.westos.pattern;

import java.util.Date;

public class TestClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        deepCopy();

    }

    public static void deepCopy () throws CloneNotSupportedException {
        User2 user = new User2();
        user.setAge(18);
        user.setName("王小帅");
        user.setBirthday(new Date());

        User2 user2 = (User2) user.clone();

        System.out.println(user == user2); // false
        System.out.println(user2.getAge());
        System.out.println(user2.getName());
        user2.getBirthday().setDate(28);
        System.out.println("新克隆用户的生日："+user2.getBirthday());
        System.out.println("王小帅的生日："+user.getBirthday());
    }

    public static void copy() throws CloneNotSupportedException {
        User user = new User();
        user.setAge(18);
        user.setName("王小帅");
        user.setBirthday(new Date());

        User user2 = (User) user.clone();

        System.out.println(user == user2); // false
        System.out.println(user2.getAge());
        System.out.println(user2.getName());
        user2.getBirthday().setDate(28);
        System.out.println("新克隆用户的生日："+user2.getBirthday());
        System.out.println("王小帅的生日："+user.getBirthday());
    }
}
