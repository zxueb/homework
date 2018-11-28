package pattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代器模式
 * 对元素进行遍历，而不用在乎底层的数据结构
 */
public class TestIterator {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(45);
        list.add(56);
        list.add(78);
        for(Integer l : list){
            System.out.println(l);
        }
        System.out.println("-------------------");
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
