package design.mode.prototype.pattern;

/**
 * <p>
 * 钱
 * </p>
 * 
 * 3. 应用
 * BeanUtils.copyProperties()
 * JSON.parseObject()
 * Guava copy 的工具类
 * spring 中的 scope = "prototype" 就是通过加载 Spring 容器中的对象模板，复制出多实例的
 * JDK 中 Arrays.copyOf()
 * 4. 场景
 * 类初始化消耗资源较多
 * 创建对象的时候步骤繁琐（数据准备、访问权限等初始化）
 * 构造函数复杂
 * 循环体重创建大量对象
 * 6. 优缺点
 * 优点： 原型模式性能比直接 new 一个对象性能高；简化了创建过程
 * 缺点： 必须配备克隆（或者可拷贝）方法；对克隆复杂对象或者对克隆出的对象进行复杂改造时，容易带来风险；浅克隆 和 深克隆 要运用得当
 *
 * @author yangkai.shen
 * @date Created in 2019-08-14 15:53
 */
public interface Money {
    /**
     * 打印
     *
     * @return {@link Money}
     */
    Money print();
}