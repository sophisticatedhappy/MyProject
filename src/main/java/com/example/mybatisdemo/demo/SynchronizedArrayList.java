package com.example.mybatisdemo.demo;

import java.util.ArrayList;

public class SynchronizedArrayList<E> {
    private final ArrayList<E> list;

    public SynchronizedArrayList() {
        this.list = new ArrayList<>();
    }

    public synchronized void add(E element) {
        list.add(element);
    }

    // 其他同步方法（如 get, remove 等）可以类似地实现

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        SynchronizedArrayList<Integer> synchronizedArrayList = new SynchronizedArrayList<>();

        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                synchronizedArrayList.add(i);
                System.out.println(Thread.currentThread().getName() + " added " + i);
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final list: " + synchronizedArrayList);
    }
}
