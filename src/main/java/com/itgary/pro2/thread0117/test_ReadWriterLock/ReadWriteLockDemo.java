package com.itgary.pro2.thread0117.test_ReadWriterLock;

import org.springframework.util.StopWatch;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by garychen on 2017/1/24.
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
        StopWatch stopWatch1 = new StopWatch();
        stopWatch1.start();
        try {
            lock.lock();                //模拟读操作
            Thread.sleep(1000);         //读操作的耗时越多,读写锁的优势就越明显
            return value;
        } finally {
            lock.unlock();
            stopWatch1.stop();
            System.out.println(Thread.currentThread().getName() +" handleRead cost " + stopWatch1.getTotalTimeSeconds() + " s");
        }
    }

    public void handleWrite(Lock lock, int index) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            lock.lock();
            Thread.sleep(1000);
            value = index;
        }finally {
            lock.unlock();
        }

        stopWatch.stop();

        System.out.println(Thread.currentThread().getName() +" handleWrite cost "+stopWatch.getTotalTimeSeconds() + " s");

    }

    public static void main(String[] args) {

        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleRead(readLock);
//                    demo.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        final Runnable wirteRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleWrite(writeLock,new Random().nextInt());
//                    demo.handleWrite(lock,new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 18; i++) {
            new Thread(readRunnable).start();
        }

        for (int i = 18; i <20; i++) {
            new Thread(wirteRunnable).start();
        }

    }

}
