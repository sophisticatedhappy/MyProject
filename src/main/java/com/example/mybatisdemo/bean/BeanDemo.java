package com.example.mybatisdemo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanDemo {

    @Bean
    public String aString(){
        return "aaaa";
    }
}
