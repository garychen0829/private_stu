package com.thread.pro12_Thread.go;

/**
 * Created by garychen on 2017/1/17.
 */
public class ThreadTestMainAndSub {


    public static void main(String[] args) {

        final ExeThread ex = new ExeThread();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    ex.mainThread(i);
                }

            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            ex.subThread(i);
        }

    }

}
