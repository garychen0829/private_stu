package com.thread.pro12_Thread.test0_Thread_JUC.test_ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by garychen on 2017/1/24.
 */
public class TimeLock implements Runnable{

    public static ReentrantLock rlock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (rlock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
            }else {
                System.out.println("get lock failed.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (rlock.isHeldByCurrentThread()) {
                rlock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLock tl = new TimeLock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);

        t1.start();
        t2.start();
    }
}
