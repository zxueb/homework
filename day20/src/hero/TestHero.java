package hero;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.valueOf;

public class TestHero {
    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("C:\\Users\\Administrator\\Desktop\\java\\homework\\day20\\heroes.txt"), Charset.forName("utf-8"));
         List<Hero> list = lines.map(str -> str.split("\t")).map(array ->
                new Hero(
                        Integer.parseInt(array[0]),
                        array[1], array[2], array[3],
                        Integer.parseInt(array[4]),
                        Integer.parseInt(array[5]),
                        Integer.parseInt(array[6]))
        ).collect(Collectors.toList());

        /**
         * 1. 找到武将中武力前三的hero对象, 提示流也可以排序
          */

        //方法1
        System.out.println("----武力前三----");
        Set<Hero> set = new TreeSet<>(new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                int num =o2.getPower() - o1.getPower();
                return num == 0 ? 1 : num;
            }
        });
        for(Hero h : list){
            set.add(h);
        }
        int num = 0;
        for(Hero h : set){
            System.out.println(h.getName() + h.getPower());
            num++;
            if(num == 3){
                break;
            }
        }
        //方法2
//        list.stream().sorted((h1,h2) ->
//                h2.getPower() - h1.getPower()).
//                limit(3).forEach(hero ->
//                System.out.println(hero.getName()+"武力值："+hero.getPower()));


        /**
         * 2. 按出生地分组
         */
        System.out.println("----按出生地分组----");
        Map<String,List<Hero>> map = list.stream().collect(Collectors.groupingBy((h) -> h.getLoc()));
        map.forEach((key,value) -> {
            //hero对象变为流的形式，用map映射，收集英雄名字
            System.out.println(key + "：" + value.stream().map(h -> h.getName()).collect(Collectors.toList()));
        });


        /**
         * 3. 找出寿命前三的武将
         */
        //方法1
        System.out.println("----寿命前三----");
        list.sort(new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                int num = (o2.getDeath() - o2.getBirth()) - (o1.getDeath() - o1.getBirth());
                return num == 0 ? 1 : num;
            }
        });
        int num1 = 0;
        for(Hero h : list){
            System.out.println(h.getName() + "寿命：" + valueOf((h.getDeath() - h.getBirth())));
            num1++;
            if(num1 == 3){
                break;
            }
        }
        //方法2
//        list.stream().sorted((h1,h2) ->
//                (h2.getDeath() - h2.getBirth()) - (h1.getDeath() - h1.getBirth())).
//                limit(3).forEach(hero ->
//                System.out.println(hero.getName() + "寿命：" + (hero.getDeath() - hero.getBirth())));


        /**
         * 4. 女性寿命最高的
          */
        System.out.println("----女性寿命最高----");
        Map<String,List<Hero>> map1 = list.stream().collect(Collectors.groupingBy((h) -> h.getSex()));
        for(Hero h : map1.get("女")){
            System.out.println(h.getName() + "寿命：" + valueOf((h.getDeath() - h.getBirth())));
            break;
        }


        /**
         * 5. 找出武力排名前三  100, 99, 97 97 ==> 4个人 吕布", "张飞", "关羽", "马超
          */
        System.out.println("----武力排名前三----");
        for(Hero h : set){
            if(h.getPower() == 100 | h.getPower() == 98 | h.getPower() == 97){
                System.out.println(h.getName() + h.getPower());
            }
        }


        /**
         * 6. 按各个年龄段分组： 0~20, 21~40, 41~60, 60以上
          */
        System.out.println("----年龄段分组----");
        Map<String,List<Hero>> map2 = list.stream().collect(Collectors.groupingBy((h) -> {
            return (h.getDeath() - h.getBirth()) > 40 ?
                    (h.getDeath() - h.getBirth()) > 60 ? "60以上": "41~60"
                    :
                    (h.getDeath() - h.getBirth()) < 21 ? "0~20" : "21~40";
        }));
        map2.forEach((key,value) -> {
            //hero对象变为流的形式，用map映射，收集英雄名字
            System.out.println(key + "：" + value.stream().map(h -> h.getName()).collect(Collectors.toList()));
        });


        /**
         * 7. 按武力段分组： >=90， 80~89, 70~79, <70
         */
        System.out.println("----武力段分组----");
        Map<String,List<Hero>> map3 = list.stream().collect(Collectors.groupingBy((h) -> {
            return h.getPower() > 79 ?
                    h.getPower() > 89 ? ">=90": "80~89"
                    :
                    h.getPower() < 70 ? "<70" : "70~79";
        }));
        map3.forEach((key,value) -> {
            //hero对象变为流的形式，用map映射，收集英雄名字
            System.out.println(key + "：" + value.stream().map(h -> h.getName()).collect(Collectors.toList()));
        });


        /**
         * 8. 按出生地分组后，统计各组人数
         */
        System.out.println("----出生地各组人数----");
        Set<String> keyset = map.keySet();
        for(String s : keyset){
                System.out.println(s + "：" + map.get(s).size() + "人");
        }
    }
}
