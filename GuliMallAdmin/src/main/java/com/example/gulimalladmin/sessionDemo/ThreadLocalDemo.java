package com.example.gulimalladmin.sessionDemo;

public class ThreadLocalDemo {

    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static final Integer THREAD_NUM = 10;

    public static void main(String[] args) {
        for(int i = 0;i< THREAD_NUM ;i ++){
            int finalI = i + 1;
            new Thread(()->{
                threadLocal.set("value"+ String.valueOf(finalI));
                String s = threadLocal.get();
                System.out.println(Thread.currentThread().getName()+s);
            },"thread"+(i+1)).start();
        }
    }
}
