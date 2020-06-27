package design.mode.singleton.pattern;

/**
 * 创建型设计模式 - 单例模式
 *
 * 饿汉式单例，在属性初始化
 *
 * 4. 应用
 * 4.1. ServletContext
 * 4.2. ServletConfig
 * 4.3. ApplicationContext
 * 4.4. DBPool
 * 5. 优缺点
 * 优点： 在内存中只有一个实例，减少内存开销；可以避免对资源的多重占用；设置全局访问点，严格控制访问
 * 缺点： 没有接口，扩展困难；扩展单例对象，只能修改代码，不符合开闭原则
 * @author yangkai.shen
 * @date Created in 2019-08-11 11:32
 */
public class EagerSingleton1 {
    private final static EagerSingleton1 INSTANCE = new EagerSingleton1();

    /**
     * 私有化构造方法
     */
    private EagerSingleton1() {
    }

    /**
     * 提供全局访问入口
     */
    public static EagerSingleton1 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("线程号: " + Thread.currentThread().getName() + "，" + EagerSingleton1.getInstance());
        }
    }

}