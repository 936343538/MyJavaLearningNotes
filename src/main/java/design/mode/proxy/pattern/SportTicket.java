package design.mode.proxy.pattern;

import design.mode.proxy.pattern.Ticket;

/**
 * <p>
 * 体育比赛门票
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-08-20 23:07
 */
public class SportTicket implements Ticket {
    /**
     * 卖票
     */
    @Override
    public void sell() {
        System.out.println("体育比赛门票");
    }
}