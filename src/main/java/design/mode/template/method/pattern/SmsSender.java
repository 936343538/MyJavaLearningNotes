package design.mode.template.method.pattern;

import java.util.Random;

/**
 * <p>
 * 短信发送器
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/11/18 17:40
 */
public class SmsSender extends BaseMessageSender {
    /**
     * 发送消息
     *
     * @param content 内容
     */
    @Override
    public void send(String content) {

    }

    /**
     * 校验消息
     *
     * @param content 数据
     */
    @Override
    public void validate(String content) {
        if (content == null || "".equals(content.trim()) || content.trim().length() != 11) {
            throw new RuntimeException("手机号码不合法");
        }
    }

    /**
     * 发送消息
     *
     * @param content 数据
     * @return {@code true} - 发送成功，{@code false} - 发送失败
     */
    @Override
    public boolean execute(String content) {
        Random random = new Random();
        if (random.nextInt(10) % 2 == 0) {
            System.out.println("短信发送成功！");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 错误记录
     *
     * @param content 数据
     */
    @Override
    public void error(String content) {
        System.err.println("短信发送失败！手机号：" + content);
    }
}