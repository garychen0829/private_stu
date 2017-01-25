package com.itgary.pro2.thread0117.test_arryalist;

import java.util.ArrayList;

/**
 * ArrayList 线程不安全.
 * Vector    线程安全
 * Created by garychen on 2017/1/23.
 */
public class ArrayListMultiThread {

    static ArrayList<Integer> al = new ArrayList<Integer>(10);

    public static class AddTread implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                al.add(i);

                System.out.println(Thread.currentThread().getName() + " 获得锁.");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddTread(),"no---1");
        Thread t2 = new Thread(new AddTread(),"no...2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(al.size());
    }
}
