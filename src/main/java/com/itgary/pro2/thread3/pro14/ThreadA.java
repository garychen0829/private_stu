package com.itgary.pro2.thread3.pro14;

/**
 * Created by garychen on 2016/11/9.
 */
public class ThreadA extends Thread{
    private Service service;

    public ThreadA(Service service){
        this.service = service;
    }

    @Override
    public void run() {
        service.testMehod();
    }
}
