package com.itgary.pro2.thread3.pro14;

/**
 * Created by garychen on 2016/11/9.
 */
public class Service {

    synchronized public void testMehod(){
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("ThredName=" + Thread.currentThread().getName() + " run beginTime=" + System.currentTimeMillis());

            int i = 1;

            while (i == 1){
                if ((""+ Math.random()).substring(0,8).equals("0.123456")) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName()
                                    + Thread.currentThread().getName()
                                    + " run exceptionTime="
                                    + System.currentTimeMillis());
                    Integer.parseInt("a");

                }else {
                    System.out.println("Thread B run time=" + System.currentTimeMillis());
                }
            }

        }
    }
}
