package com.itgary.pro12_Thread.test0_Thread_JUC.test_ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 冲入锁
 * Created by garychen on 2017/1/24.
 */
public class ReenterLock implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;


    @Override
    public  void run() {
        for (int j = 0; j < 1000; j++) {
            lock.lock();
            try {
                i++;

                System.out.println(Thread.currentThread().getName() + "在执行. [i] : " + i);
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("out : "+i);
    }
}
