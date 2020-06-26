package design.mode.abstractfactory;

/**
 * 创建型设计模式 - 抽象工厂模式
 *
 * 科技公司抽象工厂类
 * 4. 应用
 * Spring 源码
 * AbstractBeanFactory -> AbstractAutowireCapableBeanFactory / DefaultListableBeanFactory / XmlBeanFactory
 * 5. 场景
 * 客户端不依赖产品类，不关注创建、实现的细节
 * 强调一系列产品对象（产品族），一起创建时需要大量创建代码
 * 提供一类产品的库，所有的产品以同样的接口出现，从而使客户端不依赖具体实现
 * 6. 优缺点
 * 优点： 具体产品在应用层代码隔离，不关心创建细节；将一系列的产品族对象统一在一起创建
 * 缺点： 添加一种新的产品的时候，需要在工厂接口及其工厂子类都添加实现，不符合开闭原则；增加了系统的抽象性和理解难度
 * @author hongzf
 * @date 2020/6/24 08:40
 */
public abstract class AbstractTechFactory {
    /**
     * 卖手机
     *
     * @return 手机
     */
    public abstract AbstractPhone sellPhone();

    /**
     * 卖笔记本
     *
     * @return 笔记本
     */
    public abstract AbstractLaptop sellLaptop();

    /**
     * 卖耳机
     *
     * @return 耳机
     */
    public abstract AbstractEarPhone sellEarPhone();
}