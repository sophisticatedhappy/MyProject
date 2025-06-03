package com.example.demoproject.demo;

public class CustomThreadPoolDemo {

    public static void main(String[] args) {
        // 创建一个包含 3 个线程的线程池
        CustomThreadPool threadPool = new CustomThreadPool(3);

        // 提交任务到线程池
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            threadPool.execute(() -> {
                System.out.println("正在执行任务: " + taskId + "，线程: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务 " + taskId + " 执行完成");
            });
        }

        // 关闭线程池
        threadPool.shutdown();
    }
}
