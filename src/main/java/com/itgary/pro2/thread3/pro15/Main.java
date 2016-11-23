package com.itgary.pro2.thread3.pro15;


/**
 * Created by garychen on 2016/11/9.
 */
public class Main {

    synchronized public void serviceMethod(){

        try {

            System.out.println("main 1 下一步 sleep :" + Thread.currentThread().getName() + " time+" +System.currentTimeMillis());

            Thread.sleep(3000);

            System.out.println("main 2 下一步 sleep :" + Thread.currentThread().getName() + " time+" +System.currentTimeMillis());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

