package design.mode.observer.pattern;

/**
 * 行为型设计模式 - 观察者模式
 *
 * 观察者模式，测试类
 * 
 * 4. 应用
 * 1. JDK java.util.Observer 、 java.util.Observable
 * 2. Guava EventBus
 * 3. Spring ApplicationEvent
 * 4. Android ClickListerner...
 * 生活中
 * 1. 微信朋友圈通知
 * 2. 网站私信通知
 * 5. 场景
 * 观察者模式主要用于在关联行为之间建立一套触发机制的场景。
 * 6. 优缺点
 * 优点： 1、观察者和被观察者之间建立了一个抽象的耦合。 2、观察者模式支持广播通信。
 * 缺点： 1、观察者之间有过多的细节依赖、提高时间消耗及程序的复杂度。2、使用需要及其谨慎，要避免循环调用。
 *
 * @author yangkai.shen
 * @date Created in 2019/11/24 17:52
 */
public class PatternTest {
    public static void main(String[] args) {
        User xkcoding = new User("xkcoding");
        Pusher pusher = Pusher.getInstance();
        Message message = new Message("你好", "user-1", "xkcoding");
        pusher.addObserver(xkcoding);
        pusher.pushMessage(message);
    }
}