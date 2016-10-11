package com.itgary.pro2.thread2.thread_stu;

/**
 * Created by garychen on 2016/10/11.
 */
public class TestThread {

    public static void main(String[] args) {
        Thread t1 = new Thread(new CreatThread());
        t1.run();
    }
}
