package design.mode.proxy.pattern.staticproxy;

import design.mode.proxy.pattern.MusicTicket;

/**
 * <p>
 * 代理模式 - 静态代理，测试类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-08-20 22:29
 */
public class PatternTest {
    public static void main(String[] args) {
        MusicConductor conductor = new MusicConductor(new MusicTicket());
        conductor.sell();
    }
}