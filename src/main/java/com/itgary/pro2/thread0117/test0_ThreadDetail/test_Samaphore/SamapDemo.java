package com.itgary.pro2.thread0117.test0_ThreadDetail.test_Samaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量Demo
 * Created by garychen on 2017/1/24.
 */
public class SamapDemo implements Runnable{

    final Semaphore semp = new Semaphore(10);


    @Override
    public void run() {
        try {
            //获取许可
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ":done!");

            //释放资源
            semp.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        final SamapDemo demo = new SamapDemo();
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);
            System.out.println("i:"+i);
        }
    }
}
