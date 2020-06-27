package design.mode.factory.method.pattern;

/**
 * 步骤四：创建具体的不同口味的糖果工厂类
 * <p>
 * 西瓜味糖果工厂类
 * </p>
 *
 * @package: com.xkcoding.design.pattern.creational.factorymethod
 * @description: 西瓜味糖果工厂类
 * @author: yangkai.shen
 * @date: Created in 2019-02-14 11:30
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangkai.shen
 */
public class WatermelonCandyFactory extends AbstractCandyFactory {
    /**
     * 生产西瓜味糖果
     *
     * @return 西瓜味糖果
     */
    @Override
    public AbstractCandy produceCandy() {
        return new WatermelonCandy();
    }
}