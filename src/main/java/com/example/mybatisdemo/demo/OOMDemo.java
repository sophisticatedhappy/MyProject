package com.example.mybatisdemo.demo;

import java.util.ArrayList;
import java.util.List;

public class OOMDemo {

    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        testOOM();
    }

    public static void testOOM(){
        int i = 0;
        while (true){
            list.add("message_"+i);
            i++;
        }
    }
}
