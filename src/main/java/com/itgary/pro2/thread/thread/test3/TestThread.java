package com.itgary.pro2.thread.thread.test3;

/**
 * Created by gary.chen on 2016/4/12.
 */
public class TestThread extends Thread{
    private int i;

    public TestThread(int i){
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}

