package com.westos.pattern;

import java.io.*;
import java.util.Date;

public class User2 implements Cloneable, Serializable {

    private String name;
    private int age; // 18  --> 18
    private Date birthday; // #1234  --> #1234

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // ObjectOutputStream --> ByteArrayOutputStream --> byte[]

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            // 把自己（当前对象）写入输出流
            new ObjectOutputStream(os).writeObject(this);

            // 拿到字节数组
            byte[] bytes = os.toByteArray();

            // 反序列化为新对象
            ByteArrayInputStream is = new ByteArrayInputStream(bytes);

            // 对象输入流
            ObjectInputStream ois = new ObjectInputStream(is);

            return ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
