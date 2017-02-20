package com.itgary.pro12_Thread.test1_ThreadPool.demo3;

/**
 * Created by garychen on 2017/2/4.
 */
public class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + " Thread Id:" + Thread.currentThread().getId());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
