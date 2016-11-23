package com.itgary.pro2.thread.thread.test4;

import org.junit.Test;

/**
 * Created by gary on 2016/11/2.
 */
public class TestSales {

    @Test
    public void testSales(){

        ThreadSales threadSales = new ThreadSales();
        Thread t1 = new Thread(threadSales,"A");
        Thread t2 = new Thread(threadSales,"B");
        Thread t3 = new Thread(threadSales,"C");
        Thread t4 = new Thread(threadSales,"D");
        Thread t5 = new Thread(threadSales,"E");
        Thread t6 = new Thread(threadSales,"F");
        Thread t7 = new Thread(threadSales,"G");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

    }

}
