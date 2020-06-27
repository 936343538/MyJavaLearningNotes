package design.mode.prototype.pattern.deep;

import design.mode.prototype.pattern.Money;
import design.mode.prototype.pattern.Shape;
import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.*;

/**
 * 深克隆
 *
 * 一百元
 *
 * @author yangkai.shen
 * @date Created in 2019-08-14 15:56
 */
@Getter
@Setter
public class HundredMoney implements Money, Cloneable, Serializable {
    private Shape shape;

    /**
     * 打印
     *
     * @return {@link Money}
     */
    @Override
    public Money print() {
        return (Money) this.clone();
    }

    @Override
    protected Object clone() {
        return this.deepClone();
    }

    @SneakyThrows
    private Object deepClone() {
        @Cleanup ByteArrayOutputStream bos = new ByteArrayOutputStream();
        @Cleanup ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        @Cleanup ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        @Cleanup ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }
}