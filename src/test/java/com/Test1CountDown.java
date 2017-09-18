package com;

import java.util.concurrent.CountDownLatch;

/**
 * Created by garychen on 2017/9/15.
 */
public class Test1CountDown {
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        //线程一开始做一件事....
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程一开始做一件事....");


                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        }).start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //线程二开始做一件事....
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程二开始做一件事....");
            }
        }).start();
    }
}
