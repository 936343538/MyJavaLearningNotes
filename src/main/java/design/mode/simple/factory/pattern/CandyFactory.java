package design.mode.simple.factory.pattern;

/**
 * 步骤三：创建糖果工厂
 * <p>
 * 糖果工厂类
 * </p>
 *
 * @package: com.xkcoding.design.pattern.creational.simplefactory
 * @description: 糖果工厂类
 * @author: yangkai.shen
 * @date: Created in 2019-02-13 10:43
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangkai.shen
 */
public class CandyFactory {
    /**
     * 生产糖果
     *
     * @param taste 具体口味
     * @return 对应口味的糖果
     */
    public AbstractCandy produceCandy(String taste) {
        String lemon = "lemon";
        String watermelon = "watermelon";
        if (lemon.equalsIgnoreCase(taste)) {
            return new LemonCandy();
        } else if (watermelon.equalsIgnoreCase(taste)) {
            return new WatermelonCandy();
        }
        return null;
    }

    /**
     * 生产糖果
     *
     * @param c 具体口味的糖果类
     * @return 对应口味的糖果
     */
    public AbstractCandy produceCandy(Class c) {
        AbstractCandy candy = null;
        try {
            candy = (AbstractCandy) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return candy;
    }
}