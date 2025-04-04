package com.example.mybatisdemo;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

@SpringBootApplication
@MapperScan("com.example.mybatisdemo.demos.web.mapper")
public class MybatisDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MybatisDemoApplication.class, args);
//        ConfigurableEnvironment environment = context.getEnvironment();
//        String applicationName = environment.getProperty("applicationName");
//        System.out.println(applicationName);

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        BeanDefinition aString = beanFactory.getBeanDefinition("aString");
        System.out.println(aString.getClass());
    }

}
