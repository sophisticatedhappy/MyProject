package com.example.mybatisdemo.demo;

public class SynchronizedDemo {

    public static final Object obj = new Object();

    public static Integer number = 0;

    public static void main(String[] args) {


        Thread t1 = new Thread(()->{

            for(int i = 0 ;i< 10;i++){
                synchronized (obj){
                    while (number % 2 != 0){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+"->"+i);
                    number ++;
                    obj.notifyAll();
                }
            }

        },"A");


        Thread t2 = new Thread(()->{

           for(int i=0;i<10;i++){
               synchronized (obj){
                   while(number %2 != 1){
                       try {
                           obj.wait();
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                   }
                   System.out.println(Thread.currentThread().getName()+"->"+i);
                    number ++;
                    obj.notifyAll();
               }
           }

        },"B");

        t1.start();
        t2.start();

    }
}
