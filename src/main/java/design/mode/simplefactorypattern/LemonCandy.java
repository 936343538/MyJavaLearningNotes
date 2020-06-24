package design.mode.simplefactorypattern;

/**
 * 步骤二：创建具体的不同口味的糖果类
 * <p>
 * 柠檬味糖果
 * </p>
 *
 * @package: com.xkcoding.design.pattern.creational.simplefactory
 * @description: 柠檬味糖果
 * @author: yangkai.shen
 * @date: Created in 2019-02-13 10:34
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