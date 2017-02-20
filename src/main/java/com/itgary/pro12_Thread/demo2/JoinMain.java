package com.itgary.pro12_Thread.demo2;

import org.springframework.util.StopWatch;

/**
 * Created by gary on 2017/1/19.
 */
public class JoinMain {

    public volatile static int i = 0;

    public static class AddTread extends Thread{
        @Override
        public void run() {
            for (i = 0; i < 10000000; i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddTread at = new AddTread();
        StopWatch s = new StopWatch();
        s.start();
        at.start();
        at.join();

        s.stop();
        System.out.println(s.getTotalTimeMillis() + "ms");

        System.out.println(i);
    }
}
