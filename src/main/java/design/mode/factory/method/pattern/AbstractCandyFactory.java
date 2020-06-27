package design.mode.factory.method.pattern;

/**
 * 步骤二：创建抽象糖果工厂类
 * <p>
 * 糖果工厂抽象类
 * </p>
 *
 * @package: com.xkcoding.design.pattern.creational.factorymethod
 * @description: 糖果工厂抽象类
 * @author: yangkai.shen
 * @date: Created in 2019-02-14 11:29
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangkai.shen
 */
public abstract class AbstractCandyFactory {
    /**
     * 生产糖果
     *
     * @return 对应口味的糖果
     */
    public abstract AbstractCandy produceCandy();
}