package pattern.prototype;

import java.io.*;
import java.util.Date;

public class User2 implements Cloneable,Serializable{
    private String name;
    private int age;
    private Date birthday;

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
    @Override
    protected Object clone() throws CloneNotSupportedException{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try{
            new ObjectOutputStream(out).writeObject(this);
            byte[] bytes = out.toByteArray();
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            ObjectInputStream io = new ObjectInputStream(in);
            return io.readObject();
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
