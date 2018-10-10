package com.example.thymeleaf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThymeleafApplicationTests {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;

    @Test
    public void contextLoads() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("15980292662@163.com");
        mimeMessageHelper.setTo("cuixiuyin@qianxx.com");
        mimeMessageHelper.setSubject("ThymeLeaf 模板邮件");
        // 构建 html 文本
        Context ctx = new Context();
        ctx.setVariable("title", "Craig Walls");
        ctx.setVariable("content", "Hello Boot!");
        String emailText = templateEngine.process("email/email", ctx);
        mimeMessageHelper.setText(emailText, true);
        // 设置内嵌元素 cid，第一个参数表示内联图片的标识符，第二个参数标识资源引用
        mimeMessageHelper.addInline("boot", new ClassPathResource("/static/img/boot.png"));
        javaMailSender.send(mimeMessage);
    }

}
