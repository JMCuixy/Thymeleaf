package com.example.thymeleaf.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * thymeleaf 的相关自定义配置，可以不配置使用默认的即可，这里主要是为了熟悉过程。
 */
@Configuration
public class WebConfig implements ApplicationContextAware {

    private static final String UTF8 = "UTF-8";
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    private SpringResourceTemplateResolver htmlTemplateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(false);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }


    /**
     * @param templateResolver
     * @return
     */
    public TemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(templateResolver);
        return springTemplateEngine;
    }


    /**
     * 配置 Thymeleaf 视图解析器
     *
     * @param templateEngine 模板引擎
     * @return
     */
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setApplicationContext(applicationContext);
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setCharacterEncoding(UTF8);
        return viewResolver;
    }


}
