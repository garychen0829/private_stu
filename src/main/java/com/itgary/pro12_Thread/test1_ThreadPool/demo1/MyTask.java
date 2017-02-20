package com.itgary.pro12_Thread.test1_ThreadPool.demo1;

/**
 * Created by garychen on 2017/1/25.
 */
public class MyTask implements Runnable{


    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
