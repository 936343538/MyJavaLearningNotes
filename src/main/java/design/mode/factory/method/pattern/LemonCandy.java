package design.mode.factory.method.pattern;

/**
 * 步骤三：创建具体的不同口味的糖果类
 * <p>
 * 柠檬味糖果
 * </p>
 *
 * @package: com.xkcoding.design.pattern.creational.factorymethod
 * @description: 柠檬味糖果
 * @author: yangkai.shen
 * @date: Created in 2019-02-14 11:28
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangkai.shen
 */
public class LemonCandy extends AbstractCandy {
    /**
     * 口味
     */
    @Override
    public void taste() {
        System.out.println("柠檬味");
    }
}