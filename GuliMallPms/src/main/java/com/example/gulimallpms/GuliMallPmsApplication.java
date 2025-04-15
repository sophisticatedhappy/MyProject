package com.example.gulimallpms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.gulimallpms.mapper")
public class GuliMallPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuliMallPmsApplication.class, args);
    }

}
