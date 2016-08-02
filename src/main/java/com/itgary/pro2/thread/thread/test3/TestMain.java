package com.itgary.pro2.thread.thread.test3;

import org.junit.Test;

/**
 * Created by gary.chen on 2016/4/12.
 */
public class TestMain{

    @Test
    public void test(){
        TestThread t1 = new TestThread(1);
        TestThread t2 = new TestThread(2);
        TestThread t3 = new TestThread(3);
        TestThread t4 = new TestThread(4);
        TestThread t5 = new TestThread(5);
        TestThread t6 = new TestThread(6);
        TestThread t7 = new TestThread(7);
        TestThread t8 = new TestThread(8);
        TestThread t9 = new TestThread(9);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();


    }
}
