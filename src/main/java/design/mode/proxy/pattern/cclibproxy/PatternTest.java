package design.mode.proxy.pattern.cclibproxy;

import design.mode.proxy.pattern.MusicTicket;
import design.mode.proxy.pattern.TrainTicket;

/**
 * <p>
 * 代理模式 - 动态代理 - CGLIB动态代理，测试类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-08-20 23:16
 */
public class PatternTest {
    public static void main(String[] args) {
        // 代理火车票
        TrainTicket trainTicket = (TrainTicket) new Conductor().getInstance(TrainTicket.class);
        trainTicket.sell();

        // 代理演唱会门票
        MusicTicket musicTicket = (MusicTicket) new Conductor().getInstance(MusicTicket.class);
        musicTicket.sell();
    }
}