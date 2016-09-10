package com.itgary.pro2.thread.thread_callable_future;

import java.util.concurrent.Callable;

/**
 * Created by gary.chen on 2016/9/7.
 */
public class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程 call()...");
        Thread.sleep(3000);
        int num = 0;
        for (int i = 0; i < 100000; i++) {
            num++;
        }
        return num;
    }
}
