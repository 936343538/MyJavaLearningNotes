package design.mode.simplefactorypattern;

/**
 * 步骤一：创建抽象糖果类
 * <p>
 * 糖果抽象类
 * 应用
 * Slf4j日志
 * 获取日志对象 -> LoggerFactory.getLogger(String name) -> getILoggerFactory() -> getLogger(name)
 * </p>
 *
 * @package: com.xkcoding.design.pattern.creational.simplefactory
 * @description: 糖果抽象类
 * @author: yangkai.shen
 * @date: Created in 2019-02-13 10:32
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangkai.shen
 */
public abstract class Candy {

    /**
     * 口味
     */
    public abstract void taste();
}