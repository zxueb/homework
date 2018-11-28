package pattern.strategy;

import java.util.*;

/**
 * 策略模式
 * java集合或数组的排序算法
 *
 */
public class TestStrategy {
    public static void main(String[] args){
        List<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan",23));
        list.add(new Student("lisi",15));
        list.add(new Student("wangwu",43));
        list.add(new Student("zhaoliu",28));
        list.add(new Student("zhangqi",28));
        //按年龄排序
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(list);
        //按姓名排序
        Collections.sort(list,(o1,o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println(list);
        //先按年龄，再按姓名
        Collections.sort(list,(s1,s2) ->{
            int x = s1.getAge() - s2.getAge();
            return x == 0?s1.getName().compareTo(s2.getName()):x;
            }
        );
        System.out.println(list);
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
