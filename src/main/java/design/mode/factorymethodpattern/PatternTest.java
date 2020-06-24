package design.mode.factorymethodpattern;

/**
 * 步骤五： 测试
 * <p>
 * 工厂方法模式测试类
 * </p>
 *
 * @package: com.xkcoding.design.pattern.creational.factorymethod.run
 * @description: 工厂方法模式测试类
 * @author: yangkai.shen
 * @date: Created in 2019-02-14 14:54
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangkai.shen
 */
public class PatternTest {
    public static void main(String[] args) {
        CandyFactory factory1 = new LemonCandyFactory();
        Candy candy1 = factory1.produceCandy();
        candy1.taste();

        CandyFactory factory2 = new WatermelonCandyFactory();
        Candy candy2 = factory2.produceCandy();
        candy2.taste();
    }
}