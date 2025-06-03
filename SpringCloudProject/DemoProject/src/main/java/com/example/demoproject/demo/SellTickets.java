package com.example.demoproject.demo;

public class SellTickets {
    public static Integer tickets = 200;

    public static final Object lock = new Object();

    public static void main(String[] args) {

        Runnable runnableRefine = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if (tickets > 0) {
                            System.out.println(Thread.currentThread().getName() + "正在售卖第" + tickets + "张车票");
                            tickets--;
                        } else {
                            break;
                        }
                    }
                }
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (tickets > 0) {
                    synchronized (lock){
                        System.out.println(Thread.currentThread().getName()+"正在售卖第"+tickets + "张车票");
                        tickets --  ;
                    }
                }

            }
        };

        for(int i = 0;i< 4;i++){
            Thread t = new Thread(runnableRefine);
            t.start();
        }

    }
}
