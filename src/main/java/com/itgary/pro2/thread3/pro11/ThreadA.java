package com.itgary.pro2.thread3.pro11;

/**
 * Created by garychen on 2016/11/9.
 */
public class ThreadA extends Thread{

    private PublicVar publicVar;

    public ThreadA(PublicVar publicVar){
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B","BB");
    }
}
