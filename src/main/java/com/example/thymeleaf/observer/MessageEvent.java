package com.example.thymeleaf.observer;

import org.springframework.context.ApplicationEvent;

/**
 * @Description: 事件
 * @author: cuixiuyin
 * @date: 2019/01/17 12:46
 */
public class MessageEvent extends ApplicationEvent {

    private String message;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MessageEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
