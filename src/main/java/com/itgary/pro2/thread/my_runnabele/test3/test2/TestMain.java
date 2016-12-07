package com.itgary.pro2.thread.my_runnabele.test3.test2;

import org.junit.Test;

/**
 * Created by gary.chen on 2016/4/12.
 */
public class TestMain {

    //不共享数据的情况.
    @Test
    public void testMain(){
        MyThread myThread = new MyThread();

        Thread t1 = new Thread(myThread,"A");
        Thread t2 = new Thread(myThread,"B");
        Thread t3 = new Thread(myThread,"C");
        Thread t4 = new Thread(myThread,"D");
        Thread t5 = new Thread(myThread,"E");
        Thread t6 = new Thread(myThread,"F");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();



    }
}
