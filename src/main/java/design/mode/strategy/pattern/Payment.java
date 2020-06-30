package design.mode.strategy.pattern;

/**
 * 行为型设计模式 - 策略模式
 *
 * 支付接口
 *
 * 4. 应用
 * JDK 的 Comparator 接口，比如：
 * java.util.Arrays#parallelSort(int[], int, int)
 * java.util.TreeMap#TreeMap(java.util.Comparator<? super K>)
 * Spring 的 Resource 接口，比如：
 * ClassPathResource
 * UrlResource
 * FileUrlResource
 * FileSystemResource
 * ClassPathResource
 * ByteArrayResource
 * InputStreamResource
 * 5. 场景
 * 假如系统中有很多类，而他们的区别仅仅在于他们的行为不同。
 * 一个系统需要动态地在几种算法中选择一种。
 * 6. 优缺点
 * 优点： 1、策略模式符合开闭原则。2、避免使用多重条件转移语句，如 if…else… 语句、switch 语句。3、使用策略模式可以提高算法的保密性和安全性。
 * 缺点： 1、客户端必须知道所有的策略，并且自行决定使用哪一个策略类。 2、代码中会产生非常多策略类，增加维护难度。
 * @author yangkai.shen
 * @date Created in 2019/8/28 14:31
 */
public interface Payment {
    /**
     * 支付渠道
     *
     * @return 支付渠道
     */
    String channelName();

    /**
     * 余额
     *
     * @return 账户余额
     */
    double balance();

    /**
     * 支付金额
     *
     * @param money 金额
     */
    void pay(double money);
}

