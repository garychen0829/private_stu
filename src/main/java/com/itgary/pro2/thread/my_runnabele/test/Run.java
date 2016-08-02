package com.itgary.pro2.thread.my_runnabele.test;

import org.junit.Test;

/**
 * Created by gary.chen on 2016/4/12.
 */
public class Run {

    @Test
    public void test(){

        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束");
    }
}
