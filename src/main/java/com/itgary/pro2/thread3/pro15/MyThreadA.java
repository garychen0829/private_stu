package com.itgary.pro2.thread3.pro15;


/**
 * Created by garychen on 2016/11/9.
 */
public class MyThreadA extends Thread{

    private Sub sub;

    public MyThreadA(Sub sub){
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}
