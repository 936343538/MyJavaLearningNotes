package design.mode.prototype.pattern.shallow;

import design.mode.prototype.pattern.Money;
import design.mode.prototype.pattern.Shape;
import lombok.Getter;
import lombok.Setter;

/**
 * 浅克隆
 *
 * 一百元
 *
 * @author yangkai.shen
 * @date Created in 2019-08-14 15:56
 */
@Getter
@Setter
public class HundredMoney implements Money {
    private Shape shape;

    /**
     * 打印
     *
     * @return {@link Money}
     */
    @Override
    public Money print() {
        HundredMoney hundredMoney = new HundredMoney();
        hundredMoney.setShape(this.shape);
        return hundredMoney;
    }
}