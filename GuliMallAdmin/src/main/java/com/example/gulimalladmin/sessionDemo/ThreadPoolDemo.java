package com.example.gulimalladmin.sessionDemo;

import java.sql.Time;
import java.util.concurrent.*;

public class ThreadPoolDemo {

    public static final Integer TASK_NUM = 13;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1L, TimeUnit.MINUTES, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        System.out.print("计算完成，结果是：");
        Future<?> submit = threadPoolExecutor.submit(() -> {
            int res = 0;
            for (int i = 0; i < 10000; i++) {
                Thread.sleep(1);
                res += i;
            }
            return res ;
        });
        Object o = submit.get();
        System.out.println(o);
        System.out.println(check());

//        for(int i = 0;i<TASK_NUM;i++){
//            Future<?> submit = threadPoolExecutor.submit(() -> {
//                System.out.println(Thread.currentThread().getName() + "==>" + "正在处理...");
//            });
//        }
        threadPoolExecutor.shutdown();
    }
    public static int check(){
        int res = 0;
        for (int i = 0; i < 10000; i++) {
            res += i;
        }
        return res;
    }
}
