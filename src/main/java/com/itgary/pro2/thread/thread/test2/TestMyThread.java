package com.itgary.pro2.thread.thread.test2;


import org.junit.Test;

/**
 * Created by gary.chen on 2016/4/12.
 */
public class TestMyThread {

    @Test
    public void test() {
        MyThread thread = new MyThread();
        thread.setName("gary_chen");
        thread.start();

        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);

                Thread.sleep(1000);

                System.out.println("main=" + Thread.currentThread().getName());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
