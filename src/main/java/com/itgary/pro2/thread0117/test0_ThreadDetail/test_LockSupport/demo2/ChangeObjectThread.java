package com.itgary.pro2.thread0117.test0_ThreadDetail.test_LockSupport.demo2;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by garychen on 2017/1/25.
 */
public class ChangeObjectThread extends Thread {

    public Object u = new Object();

    public ChangeObjectThread(String name){
        super.setName(name);
    }

    @Override
    public void run() {
        synchronized (u){
            System.out.println("in :" + getName());

            LockSupport.park();

            if (Thread.interrupted()) {
                System.out.println(getName() + " 被中断了.");
            }
        }
        System.out.println("执行结束.");
    }

}
