package com.itgary.pro2.thread.thread.test4;

/**
 * Created by gary on 2016/11/2.
 */
public class ThreadSales extends Thread{

    private int count = 10;

//    @Override
//    public void run() {
//        //卖东西 数量减少
//        count--;
//        System.out.println(this.currentThread().getName()+"货物还剩：["+count+"]个");
//
//    }


    @Override
    synchronized public void run() {
        //卖东西 数量减少
        count--;
        System.out.println(this.currentThread().getName()+"货物还剩：["+count+"]个");

    }
}
