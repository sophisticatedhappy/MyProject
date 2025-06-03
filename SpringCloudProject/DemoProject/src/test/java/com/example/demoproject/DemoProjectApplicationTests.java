package com.example.demoproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoProjectApplicationTests {

    @Test
    void contextLoads() {
        String s = "abc";
        String substring = s.substring(1, 2);
        System.out.println(substring);
    }

    @Test
    void test1(){
        int a =1;
        int b =2;
        int c =3;
        System.out.println(b += c -- / + + a);
    }


    @Test
    void test2(){

    }

}
