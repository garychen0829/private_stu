package com.itgary.pro2.thread0117;

/**
 * Created by garychen on 2017/1/17.
 */
public class ThreadTest {

    public static void main(String[] args) {
        new ThreadTest().init();
    }


    public void init() {
        final Business business = new Business();
        new Thread(
            new Runnable() {
                public void run() {
                    for (int i = 0; i < 50; i++) {
                        business.MainThread(i);
                    }
                }

            }
        ).start();

        for (int i = 0; i < 50; i++) {
            business.SubThread(i);
        }
    }
}
