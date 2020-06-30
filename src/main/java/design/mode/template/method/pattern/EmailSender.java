package design.mode.template.method.pattern;

import java.util.Random;

/**
 * <p>
 * 邮件发送器
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/11/18 17:34
 */
public class EmailSender extends BaseMessageSender {
    /**
     * 校验消息
     *
     * @param content 数据
     */
    @Override
    public void validate(String content) {
        if (content == null || "".equals(content.trim())) {
            throw new RuntimeException("数据不能为空");
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
            System.out.println("邮件发送成功！");
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
        System.err.println("邮件发送失败！发送内容：" + content);
    }
}