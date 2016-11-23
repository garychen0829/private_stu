package com.itgary.pro2.threadStu.demo2;

/**
 * Created by garychen on 2016/11/2.
 */
public class RandomThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int)(Math.random() * 1000);
                //System.out.println(time);
                Thread.sleep(time);
                System.out.println("run = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
