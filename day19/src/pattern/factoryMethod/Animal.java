package pattern.factoryMethod;

/**
 * 工厂方法模式
 * 创建产品对象的公共接口，而工厂子类则负责生成具体的产品对象
 * 核心接口不在创建新的对象，推迟到子类创建
 * 优点：利于新增新的对象，后期维护容易
 * 缺点：代码量大
 */

public abstract class Animal {
    public abstract void eat();
}
