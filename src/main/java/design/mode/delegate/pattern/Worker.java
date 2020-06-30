package design.mode.delegate.pattern;

/**
 * 行为型设计模式 - 委派模式
 *
 * 工人接口
 *
 * 4. 应用
 * 在 Spring 中以 Delegate 结尾的一般都是实现了委派模式的
 * 例如：BeanDefinitionParserDelegate
 * Spring MVC 中的 DispatcherServlet 根据 handlerMapping 转发具体执行逻辑到 Controller
 * 5. 优缺点
 * 优点： 对内隐藏实现, 简化调用。
 * 缺点： 当实际处理业务的类需要扩展时，派发命令的类也需要对应做调整，不符合开闭原则。
 *
 * @author yangkai.shen
 * @date Created in 2019/8/28 11:17
 */
public interface Worker {
    /**
     * 做事情
     *
     * @param thing 任务
     */
    void doing(String thing);
}