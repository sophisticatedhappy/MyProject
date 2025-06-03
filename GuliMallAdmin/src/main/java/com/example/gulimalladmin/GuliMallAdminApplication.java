package com.example.gulimalladmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.example.gulimalladmin.mapper")
@ServletComponentScan(basePackages = "com.example.gulimalladmin.sessionDemo")
public class GuliMallAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuliMallAdminApplication.class, args);
    }

}
