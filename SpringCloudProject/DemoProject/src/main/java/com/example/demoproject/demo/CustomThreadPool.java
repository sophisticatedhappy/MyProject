package com.example.demoproject.demo;

import java.util.*;

public class CustomThreadPool {

    // 线程池中的工作线程列表
    private final List<WorkerThread> workerThreads;
    // 任务队列
    private final LinkedList<Runnable> taskQueue;
    // 线程池是否关闭的标志
    private boolean isShutdown;

    public CustomThreadPool(int poolSize) {
        this.workerThreads = new LinkedList<>();
        this.taskQueue = new LinkedList<>();
        this.isShutdown = false;

        // 初始化工作线程
        for (int i = 0; i < poolSize; i++) {
            WorkerThread worker = new WorkerThread();
            workerThreads.add(worker);
            worker.start();
        }
    }

    // 向线程池提交任务
    public synchronized void execute(Runnable task) {
        if (isShutdown) {
            throw new IllegalStateException("线程池已关闭，无法提交任务");
        }
        taskQueue.add(task);
        // 唤醒等待的线程
        notify();
    }

    // 关闭线程池
    public synchronized void shutdown() {
        this.isShutdown = true;
        // 唤醒所有等待的线程
        notifyAll();
        for (WorkerThread worker : workerThreads) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 工作线程类
    private class WorkerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable task;
                synchronized (CustomThreadPool.this) {
                    while (taskQueue.isEmpty() && !isShutdown) {
                        try {
                            // 若任务队列为空且线程池未关闭，线程进入等待状态
                            CustomThreadPool.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (isShutdown && taskQueue.isEmpty()) {
                        break;
                    }
                    // 从任务队列中取出一个任务
                    task = taskQueue.poll();
                }
                if (task != null) {
                    try {
                        // 执行任务
                        task.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }




}
