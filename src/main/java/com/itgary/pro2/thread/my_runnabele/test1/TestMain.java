package com.itgary.pro2.thread.my_runnabele.test1;

import org.junit.Test;

/**
 * Created by gary.chen on 2016/4/12.
 */
public class TestMain {

    //不共享数据的情况.
    @Test
    public void testMain(){
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");

        a.start();
        b.start();
        c.start();

    }
}
