package com.example.gulimalladmin.sessionDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 定义注解
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@interface MyAnnotation {
    String value() default "";
    int count() default 1;
    Class<?>[] groups() default {};
}

// 使用注解
@MyAnnotation(value = "类注解示例", count = 3)
class MyClass {
    @MyAnnotation("字段注解示例")
    private String myField;

    @MyAnnotation(groups = {String.class, Integer.class})
    public void myMethod() {
        // 方法实现
    }
}

// 处理注解
public class MyAnnotationDemo {
    public static void main(String[] args) {
        Class<?> clazz = MyClass.class;

        // 检查类上的注解
        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
            System.out.println("类注解: " + annotation.value());
            System.out.println("Count: " + annotation.count());
        }

        // 检查字段上的注解
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
                System.out.println("字段 " + field.getName() + " 的注解: " + annotation.value());
            }
        }

        // 检查方法上的注解
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                System.out.println("方法 " + method.getName() + " 的groups:");
                for (Class<?> group : annotation.groups()) {
                    System.out.println("  - " + group.getName());
                }
            }
        }
    }
}
