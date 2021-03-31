package com.example.thymeleaf.config;

import com.example.thymeleaf.advisor.PlayAdvice;
import com.example.thymeleaf.advisor.PlayPointcut;
import com.example.thymeleaf.advisor.PlayService;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @Author: xiuyin.cui@joymo.tech
 * @Date: 2021/3/30 16:15
 * @Description:
 */
@EnableTransactionManagement
@Configuration
public class SpringConfig {

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public TransactionTemplate transactionManager(PlatformTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public PlayPointcut playPointcut() {
        return new PlayPointcut();
    }

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public PlayAdvice playAdvice() {
        return new PlayAdvice();
    }

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public DefaultPointcutAdvisor playPointcutAdvisor() {
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setPointcut(playPointcut());
        defaultPointcutAdvisor.setAdvice(playAdvice());
        return defaultPointcutAdvisor;
    }

    @Bean
    public PlayService playService() {
        return new PlayService();
    }

}
