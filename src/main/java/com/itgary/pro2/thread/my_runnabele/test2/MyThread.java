package com.itgary.pro2.thread.my_runnabele.test2;

/**
 * Created by gary.chen on 2016/4/12.
 */
public class MyThread extends Thread {
    private int count = 5;

    @Override
    public void run() {
        super.run();

        count--;
        System.out.println("由 " + this.currentThread().getName() + "开始计算,count=" + count);

    }
}
