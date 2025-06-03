package com.example.gulimalladmin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GuliMallAdminApplicationTests {

    @Test
    void contextLoads() {
        String a = "a";
        String b = "b";
        String template = "ab";
        String c = "a" + "b";
        String d = a + b;
        System.out.println(template == c); //true
        System.out.println(template == d); //false
    }

}
