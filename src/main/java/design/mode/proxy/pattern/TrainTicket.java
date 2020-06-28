package design.mode.proxy.pattern;

import design.mode.proxy.pattern.Ticket;

/**
 * <p>
 * 火车票
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-08-20 23:18
 */
public class TrainTicket implements Ticket {
    @Override
    public void sell() {
        System.out.println("火车票");
    }
}

