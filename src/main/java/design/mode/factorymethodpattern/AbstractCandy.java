package design.mode.factorymethodpattern;

/**
 * 创建型设计模式 - 工厂方法模式
 *
 * 步骤一：创建抽象糖果类
 *
 * 糖果抽象类
 * 5. 应用
 * JDK中的应用
 * 获取日历对象 -> Calendar.getInstance() -> createCalendar(TimeZone zone,Locale aLocale)
 * 6. 场景
 * 工厂类负责创建的对象比较少：由于创建的对象较少，不会造成工厂方法中的业务逻辑太过复杂。
 * 客户端只知道传入工厂类的参数，对于如何创建对象不关心：客户端既不需要关心创建细节，甚至连类名都不需要记住，只需要知道类型所对应的参数。
 * 7. 优缺点
 * 优点： 以本例为例，1、扩展性高，如果想增加一个具体口味的糖果，只需要添加具体口味的糖果实现，同时添加具体口味的糖果工厂即可。2、屏蔽糖果的具体实现，调用方只关心抽象实体的通用接口在具体口味糖果类中的不同实现。
 * 缺点： 以本例为例，每增加一种糖果口味，都需要增加一种具体的实现类，同时增加具体的工厂类，如果系统中存在很多不同口味的糖果，则会导致类的数量成倍增加，增加了系统的复杂度。
 *
 * @package: com.xkcoding.design.pattern.creational.factorymethod
 * @description: 糖果抽象类
 * @author: yangkai.shen
 * @date: Created in 2019-02-14 11:28
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangkai.shen
 */
public abstract class AbstractCandy {

    /**
     * 口味
     */
    public abstract void taste();
}