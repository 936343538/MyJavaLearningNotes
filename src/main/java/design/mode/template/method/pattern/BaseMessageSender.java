package design.mode.template.method.pattern;

/**
 * 消息发送器
 * <p>
 * 4. 应用
 * Spring Data 这个模块下存在特别多的应用
 * 比如：
 * JdbcTemplate、RedisTemplate、MongoTemplate、ElasticsearchTemplate
 * 5. 场景
 * 一次性实现一个算法的主体流程的部分，并将可变的行为留给子类来实现。
 * 各子类中公共的行为被提取出来并集中到一个公共的父类中，从而避免代码重复。
 * 6. 优缺点
 * 优点： 1、提高代码的复用性。2、提高代码的扩展性。3、符合开闭原则。
 * 缺点： 1、导致类的数目增加。2、间接地增加了系统实现的复杂度。3、继承关系存在自身缺点，如果父类添加了新的抽象方法，所有子类都需要重新改一遍。
 *
 * @author yangkai.shen
 * @date Created in 2019/11/18 17:22
 */
public abstract class BaseMessageSender implements IBaseMessageSender{
    /**
     * 发送消息
     *
     * @param content 内容
     */
    @Override
    public void send(String content) {
        validate(content);
        if (!execute(content)) {
            error(content);
        }
    }

    /**
     * 校验消息
     *
     * @param content 数据
     */
    @Override
    public abstract void validate(String content);

    /**
     * 发送消息
     *
     * @param content 数据
     * @return {@code true} - 发送成功，{@code false} - 发送失败
     */
    @Override
    public abstract boolean execute(String content);

    /**
     * 错误记录
     *
     * @param content 数据
     */
    @Override
    public abstract void error(String content);
}