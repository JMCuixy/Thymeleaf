package com.example.thymeleaf;


/**
 * @Author: xiuyin.cui@joymo.tech
 * @Date: 2021/3/31 17:27
 * @Description:
 */
public class ClassTest {

    public static void main(String[] args) {
        ClassTest classTest = new ClassTest();
        String name = classTest.getClass().getName();
        Class<?>[] classes = classTest.getClass().getClasses();
        Class<?> declaringClass = classes.getClass().getDeclaringClass();
        Class<?>[] declaredClasses = classes.getClass().getDeclaredClasses();
    }


}
