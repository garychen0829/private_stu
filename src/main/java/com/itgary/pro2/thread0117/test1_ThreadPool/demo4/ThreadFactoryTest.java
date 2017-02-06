package com.itgary.pro2.thread0117.test1_ThreadPool.demo4;

import com.itgary.pro2.thread0117.test1_ThreadPool.demo3.MyTask;

import java.util.concurrent.*;

/**
 * 自定义线程创建:ThreadFactioy
 * Created by garychen on 2017/2/6.
 */
public class ThreadFactoryTest {

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();

        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                System.out.println("create " + t);
                return t;
            }
        });

        for (int i = 0; i < 5; i++) {
            es.submit(task);
        }
        Thread.sleep(2000);
    }
}
