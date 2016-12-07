package com.itgary.pro2.thread3.pro10;

/**
 * Created by garychen on 2016/11/9.
 */
public class ThreadA extends Thread{

    private MyObject object;

    public ThreadA(MyObject object){
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}
