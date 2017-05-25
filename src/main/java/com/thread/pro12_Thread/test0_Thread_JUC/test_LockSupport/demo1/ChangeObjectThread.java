package com.thread.pro12_Thread.test0_Thread_JUC.test_LockSupport.demo1;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by garychen on 2017/1/25.
 */
public class ChangeObjectThread extends Thread {

    private Object u = new Object();

    public ChangeObjectThread(String name) {
        super.setName(name);
    }

    @Override
    public void run() {
        synchronized (u){
            System.out.println("in :" + getName());
            LockSupport.park(this);
        }
    }


}
