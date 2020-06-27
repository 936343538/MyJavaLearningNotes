package design.mode.singleton.pattern;

/**
 * <p>
 * 懒汉式单例，简单实现
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-08-11 19:15
 */
public class LazySingletonSimple {
    private static LazySingletonSimple INSTANCE = null;

    private LazySingletonSimple() {
    }

    /**
     * 此处需要加 {@code synchronized}，保证线程安全
     */
    public synchronized static LazySingletonSimple getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingletonSimple();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("线程号: " + Thread.currentThread().getName() + "，" + LazySingletonSimple.getInstance());
        }
    }
}