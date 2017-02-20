package com.itgary.pro12_Thread.test1_ThreadPool.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定线程数量的线程池
 * Created by garychen on 2017/1/25.
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        ExecutorService ex = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 13; i++) {
            ex.submit(task);
        }
        ex.shutdown();
    }
}
