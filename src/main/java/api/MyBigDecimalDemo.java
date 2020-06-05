package api;

import java.math.BigDecimal;


/**
 * @author hongzf
 * @date 2020/6/4
 */
public class MyBigDecimalDemo {
    public static void main(String[] args) {
        //数据初始化 注意精度计算要使用字符串构造方法传递 String 类型的参数
        BigDecimal b1 = new BigDecimal("10.0151646");
        BigDecimal b2 = new BigDecimal("3.0");
        //加法 add
//        System.out.println(b1.add(b2));//2.2
        //减法 subtract
//        System.out.println(b1.subtract(b2));
        //乘法
        multiply(b1, b2);
        //除法
//        divide(b1, b2);
    }

    /**
     * 乘法
     *
     * @param b1
     * @param b2
     */
    private static void multiply(BigDecimal b1, BigDecimal b2) {
        BigDecimal multiply = b1.multiply(b2);
        //setScale 第一个参数:小数点后保留的小数,第二个参数:舍入模式(参考除法)
        BigDecimal bigDecimal = multiply.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal);
    }

    /**
     * 除法
     *
     * @param b1
     * @param b2
     */
    private static void divide(BigDecimal b1, BigDecimal b2) {
        //第一个参数:除数
        //第二个参数:小数点后保留的小数
        //第三个参数:舍入模式

        //进一法: BigDecimal.ROUND_UP
        BigDecimal divide1 = b1.divide(b2, 2, BigDecimal.ROUND_UP);
        //3.34
        System.out.println(divide1);

        //去尾法: BigDecimal.ROUND_FLOOR
        BigDecimal divide2 = b1.divide(b2, 2, BigDecimal.ROUND_FLOOR);
        //3.33
        System.out.println(divide2);

        //四舍五入: BigDecimal.ROUND_HALF_UP
        BigDecimal divide3 = b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);
        //3.33
        System.out.println(divide3);
    }

}
