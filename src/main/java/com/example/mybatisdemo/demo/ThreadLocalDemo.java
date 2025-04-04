package com.example.mybatisdemo.demo;

public class ThreadLocalDemo {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {



        new Thread(()->{
            threadLocal.set("a thread message");
            String s = threadLocal.get();
            System.out.println(Thread.currentThread().getName()+"->"+ s);
        },"a").start();

        new Thread(()->{
            threadLocal.set("b thread message");
            String s = threadLocal.get();
            System.out.println(Thread.currentThread().getName()+"->"+ s);
        },"B").start();


    }
}
