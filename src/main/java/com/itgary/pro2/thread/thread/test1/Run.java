package com.itgary.pro2.thread.thread.test1;

import org.junit.Test;

/**
 * Created by gary.chen on 2016/4/12.
 */
public class Run {

    @Test
    public void test(){
        Test2MyThread t = new Test2MyThread();
        t.start();
        System.out.println("运行结束...");
    }
}
