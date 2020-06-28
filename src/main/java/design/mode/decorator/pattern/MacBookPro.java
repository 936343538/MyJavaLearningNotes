package design.mode.decorator.pattern;

/**
 * 结构型设计模式 - 装饰者模式
 *
 * <p>
 * 苹果笔记本
 * </p>
 *
 * 5. 场景
 * 用于扩展一个类的功能。
 * 给一个类添加附加职责。
 * 动态的给一个对象添加功能，这些功能可以再动态的撤销。
 * 6. 优缺点
 * 优点： 1、装饰者是继承的有力补充，比继承灵活，不改变原有对象的情况下动态地给一个对象 扩展功能，即插即用。 2、通过使用不同装饰类以及这些装饰类的排列组合，可以实现不同效果。 3、装饰者完全遵守开闭原则。
 * 缺点： 1、会出现更多的代码，更多的类，增加程序复杂性。 2、动态装饰时，多层装饰时会更复杂。
 *
 * @author yangkai.shen
 * @date Created in 2019/12/13 16:51
 */
public interface MacBookPro {
    /**
     * 套餐名称
     *
     * @return 套餐名称
     */
    String getComboName();

    /**
     * 硬盘
     *
     * @return 硬盘
     */
    String getHardDisk();

    /**
     * 内存
     *
     * @return 内存
     */
    String getMemory();

    /**
     * 价格
     *
     * @return 价格
     */
    Double getPrice();
}