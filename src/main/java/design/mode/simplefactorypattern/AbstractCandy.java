package design.mode.simplefactorypattern;

/**
 * 创建型设计模式 - 简单工厂模式
 *
 * 步骤一：创建抽象糖果类
 *
 * 糖果抽象类
 * 5. 应用
 * Slf4j日志
 * 获取日志对象 -> LoggerFactory.getLogger(String name) -> getILoggerFactory() -> getLogger(name)
 * 6. 场景
 * 工厂类负责创建的对象比较少：由于创建的对象较少，不会造成工厂方法中的业务逻辑太过复杂。
 * 客户端只知道传入工厂类的参数，对于如何创建对象不关心：客户端既不需要关心创建细节，甚至连类名都不需要记住，只需要知道类型所对应的参数。
 * 7. 优缺点
 * 优点： 以本例为例，1、糖果调用方想创建一个具体口味的糖果对象，只要知道其口味就可以。 2、扩展性高，如果想增加一个具体口味的糖果，只要在工厂类中添加一种生产逻辑就可以实现。 3、屏蔽糖果的具体实现，调用方只关心抽象实体的通用接口在具体口味糖果类中的不同实现。
 * 缺点： 以本例为例，每增加一种糖果口味，都需要增加一种具体的实现类，同时在工厂类中添加对应的生产逻辑，如果系统中存在很多不同口味的糖果，则会导致类的数量成倍增加，增加了系统的复杂度，同时增加类之间的依赖。
 *
 * @package: com.xkcoding.design.pattern.creational.simplefactory
 * @description: 糖果抽象类
 * @author: yangkai.shen
 * @date: Created in 2019-02-13 10:32
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