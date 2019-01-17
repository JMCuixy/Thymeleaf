package com.example.thymeleaf.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/17 12:53
 */
@Component
public class ResponseHandler implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(messageEvent.getMessage());
    }

}
