package com.itgary.pro2.thread3.pro13;

/**
 * Created by garychen on 2016/11/9.
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        Sub b = new Sub();
        b.operaterISubMethod();
    }
}
