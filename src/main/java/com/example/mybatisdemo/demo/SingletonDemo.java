package com.example.mybatisdemo.demo;

public class SingletonDemo {
    public static void main(String[] args) {

        if(Singleton.singleton == null){
            System.out.println("是null的");
        }

        //创建单例
        Singleton singleton = Singleton.getSingleton();


        if(Singleton.singleton == null){
            System.out.println("是null的");
        }else{
            System.out.println("不空了");
            System.out.println(Singleton.singleton);
        }

    }
}
