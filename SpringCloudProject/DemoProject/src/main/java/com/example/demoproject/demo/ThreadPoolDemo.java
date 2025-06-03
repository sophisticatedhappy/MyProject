package com.example.demoproject.demo;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {

//        MyThreadPool myThreadPool = new MyThreadPool();
//
//        myThreadPool.execute(()->{
//            System.out.println("hello");
//        });
        ThreadPoolExecutor threadPoolExecutor = buildThreadPool();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"正在操作中...");
            }
        };
        for(int i = 0;i< 150;i++){
            Thread t = new Thread(runnable);
            threadPoolExecutor.submit(t);
        }

        Thread.sleep(1000);
        threadPoolExecutor.shutdown();
    }

    public static ThreadPoolExecutor buildThreadPool(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 8, 1, TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(10), new ThreadFactoryBuilder().build(), new ThreadPoolExecutor.CallerRunsPolicy());
        return threadPoolExecutor;
    }


    public static class MyThreadPool{

        int coreThread;

        int maxThread;

        int tempNum ; //当前创建的线程数

        List<Runnable> list = new ArrayList<>() ; //充当阻塞队列

        public final Integer MAX_LENGTH = 1000;

        public MyThreadPool(){
        }

        public MyThreadPool(int coreThread,int maxThread,int tempNum) {
            this.coreThread = coreThread;
            this.maxThread = maxThread;
            this.tempNum = tempNum ;
        }




        public void execute(Runnable runnable){

            if(tempNum < coreThread){
                Thread t = new Thread(runnable);
                t.start();
            }else{
                list.add(runnable); // 入队列
                if(tempNum < maxThread){
                    Runnable runnable1 = list.get(0);
                    list.remove(0);
                    Thread t = new Thread(runnable1);
                    t.start();
                }
                if(list.size() >= MAX_LENGTH){

                }
            }

        }



    }
}
