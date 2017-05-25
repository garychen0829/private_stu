package com.thread.pro12_Thread.test1_ThreadPool.demo2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService在指定时间执行某任务的功能.
 *      1.如在某个固定的延迟之后执行.
 *      2.或周期性执行某个任务.
 * Executors.newScheduledThreadPool(10) 返回一个ScheduledExecutorService对象,该线程可以指定该线程数量
 * Created by garychen on 2017/2/4.
 */
public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0,2, TimeUnit.SECONDS);
    }
}
