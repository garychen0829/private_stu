package com.itgary.pro2.thread0117.test_CountDownLatch;

import org.springframework.util.StopWatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 10个线程完成,等待在CountDownLatch上的线程才能继续执行.
 * Created by garychen on 2017/1/24.
 */
public class CountDownLatchDemo implements Runnable{

    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        //模拟检查任务
        try {
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println("check complete");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopWatch.stop();
        System.out.println("cost: "+ stopWatch.getTotalTimeMillis() + " ms");

    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.submit(demo);
        }
        //等待检查
        end.await();
        System.out.println("Fire!");
        exec.shutdown();
    }
}
