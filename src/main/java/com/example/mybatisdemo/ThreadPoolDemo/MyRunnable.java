package com.example.mybatisdemo.ThreadPoolDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class MyRunnable implements Runnable{

    public String message;

    public MyRunnable(String message){
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(this.message+" ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
