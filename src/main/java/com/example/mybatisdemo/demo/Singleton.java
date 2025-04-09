package com.example.mybatisdemo.demo;

public class Singleton {

    public static volatile Singleton singleton ;

    public Singleton(){}

    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
