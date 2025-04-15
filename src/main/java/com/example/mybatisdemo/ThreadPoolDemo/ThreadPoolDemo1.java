package com.example.mybatisdemo.ThreadPoolDemo;

import java.util.concurrent.*;

public class ThreadPoolDemo1 {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for(int i =0; i< 100;i++){
            Runnable runnable = new MyRunnable("第"+ (i+1) + "个任务正在处理中...");
            Future<?> submit = threadPoolExecutor.submit(runnable);
        }

        threadPoolExecutor.shutdown();

        while(! threadPoolExecutor.isTerminated()){

        }
        System.out.println("Thread pool is over..");

    }
}
