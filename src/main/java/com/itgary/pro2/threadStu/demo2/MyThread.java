package com.itgary.pro2.threadStu.demo2;

/**
 * Created by garychen on 2016/11/2.
 */
public class MyThread extends Thread{

    int i;
    public MyThread(int i){
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}
