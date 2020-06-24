package design.mode.factorymethodpattern;

/**
 * 步骤四：创建具体的不同口味的糖果工厂类
 * <p>
 * 柠檬味糖果工厂类
 * </p>
 *
 * @package: com.xkcoding.design.pattern.creational.factorymethod
 * @description: 柠檬味糖果工厂类
 * @author: yangkai.shen
 * @date: Created in 2019-02-14 11:30
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangkai.shen
 */
public class LemonCandyFactory extends AbstractCandyFactory {
    /**
     * 生产柠檬味糖果
     *
     * @return 柠檬味糖果
     */
    @Override
    public AbstractCandy produceCandy() {
        return new LemonCandy();
    }
}