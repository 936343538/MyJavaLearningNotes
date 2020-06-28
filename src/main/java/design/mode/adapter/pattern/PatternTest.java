package design.mode.adapter.pattern;

/**
 * <p>
 * 适配器模式 - 测试类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/9/16 17:15
 */
public class PatternTest {
    public static void main(String[] args) {
        TypeC typeC = new TypeCAdapter(new Usb());
        typeC.slot();
    }
}