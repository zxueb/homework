package pattern.abstractFactory.testFactory;
/**
 * 抽象工厂方法
 *提供了一种方式，可将一组具有同一主题的单独的工厂封装起来
 */

import pattern.abstractFactory.factory.HeroAnny;
import pattern.abstractFactory.factory.HeroMary;
import pattern.abstractFactory.factory.HeroYasa;

public class Tset {
    public static void main(String[] args){
        HeroAnny anny = new HeroAnny();
        System.out.println("Anny描述：");
        anny.createPerson().adjunct();
        anny.createKind().skill();

        System.out.println("================");
        HeroMary mary = new HeroMary();
        System.out.println("Mary描述");
        mary.createPerson().adjunct();
        mary.createKind().skill();

        System.out.println("================");
        HeroYasa yasa = new HeroYasa();
        System.out.println("Yasa描述");
        yasa.createPerson().adjunct();
        yasa.createKind().skill();
    }

}
