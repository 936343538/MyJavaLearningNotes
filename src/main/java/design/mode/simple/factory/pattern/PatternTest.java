package design.mode.simple.factory.pattern;

/**
 * 步骤四：调用工厂类生产具体口味的糖果
 * <p>
 * 简单工厂模式测试类
 * </p>
 *
 * @package: com.xkcoding.design.pattern.creational.simplefactory.run
 * @description: 简单工厂模式测试类
 * @author: yangkai.shen
 * @date: Created in 2019-02-13 10:40
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangkai.shen
 */
public class PatternTest {
    public static void main(String[] args) {
        CandyFactory factory = new CandyFactory();
        // 测试工厂类方法 - 1
        AbstractCandy candy1 = factory.produceCandy("lemon");
        candy1.taste();
        AbstractCandy candy2 = factory.produceCandy("watermelon");
        candy2.taste();

        // 测试工厂类方法 - 2
        AbstractCandy candy3 = factory.produceCandy(LemonCandy.class);
        candy3.taste();
        AbstractCandy candy4 = factory.produceCandy(WatermelonCandy.class);
        candy4.taste();
    }
}