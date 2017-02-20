package com.itgary.pro2.thread0117.test0_ThreadDetail.test_LockSupport.demo2;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by garychen on 2017/1/25.
 */
public class LockSupportIntDemo {
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();

        //中断处于park状态的t1
        t1.interrupt();

        LockSupport.unpark(t2);

    }

}
