package com.example.thymeleaf.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description: 主题 - 被观察者
 * @author: cuixiuyin
 * @date: 2019/01/17 12:49
 */
@Component
public class EventSource implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;


    public void sendMsg() {
        this.applicationEventPublisher.publishEvent(new MessageEvent(this, "2019-01-17 13:01:25"));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
