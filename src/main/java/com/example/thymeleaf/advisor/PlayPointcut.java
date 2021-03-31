package com.example.thymeleaf.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;

/**
 * @Author: xiuyin.cui@joymo.tech
 * @Date: 2021/3/31 10:23
 * @Description: Pointcut：用于定义拦截目标集合
 */
public class PlayPointcut implements Pointcut {


    @Override
    public ClassFilter getClassFilter() {
        return new PlayClassFilter();
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new PlayMethodMatcher();
    }


    /**
     * PlayClassFilter 的定义
     */
    static class PlayClassFilter implements ClassFilter {

        @Override
        public boolean matches(Class clazz) {
            if (clazz.getSimpleName().equals("PlayService")) {
                return true;
            }
            return false;
        }
    }

    /**
     * PlayMethodMatcher 的定义
     */

    static class PlayMethodMatcher implements MethodMatcher {
        @Override
        public boolean isRuntime() {
            return true;
        }

        @Override
        public boolean matches(Method method, Class c) {
            if (c.getSimpleName().equals("PlayService") && method.getName().contains("play")) {
                return true;
            }
            return false;
        }

        @Override
        public boolean matches(Method method, Class c, Object[] args) {
            if (c.getSimpleName().equals("PlayService") && method.getName().contains("play")) {
                return true;
            }
            return false;
        }
    }
}
