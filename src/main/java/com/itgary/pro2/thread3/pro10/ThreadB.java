package com.itgary.pro2.thread3.pro10;

/**
 * Created by garychen on 2016/11/9.
 */
public class ThreadB extends Thread{

    private MyObject object;

    public ThreadB(MyObject object){
        this.object = object;
    }

    @Override
    public void run() {
        object.methodB();
    }
}
