package com.itgary.pro2.threadStu.demo2;

import org.junit.Test;

/**
 * Created by garychen on 2016/11/2.
 */
public class TestThread {
    /**
     * Thread 中start 和 run的区别
     * @param args
     */
    public static void main(String[] args) {
        RandomThread r = new RandomThread();
        r.setName("wrh");
        r.start();
        //r.run();

        System.out.println("======================");

        try {
            for (int i = 0; i < 10; i++) {
                int time = (int)(Math.random() * 1000);
                System.out.println(time);
                Thread.sleep(time);
                System.out.println("main = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }


    @Test
    public void test(){
        MyThread r1 = new MyThread(1);
        MyThread r2 = new MyThread(2);
        MyThread r3 = new MyThread(3);
        MyThread r4 = new MyThread(4);
        MyThread r5 = new MyThread(5);

        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r5.start();
    }

}

