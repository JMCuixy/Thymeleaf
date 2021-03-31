package com.example.thymeleaf.advisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: xiuyin.cui@joymo.tech
 * @Date: 2021/3/31 10:22
 * @Description: Advice：用于定义拦截行为
 */
public class PlayAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("my before advice");
        // 如果再调用这句，则目标方法会执行多一次
        // method.invoke(target, args);
    }
}
