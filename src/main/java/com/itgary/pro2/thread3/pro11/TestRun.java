package com.itgary.pro2.thread3.pro11;

/**
 * Created by garychen on 2016/11/9.
 */
public class TestRun {

    public static void main(String[] args) {
        try {
            PublicVar publicVar = new PublicVar();
            ThreadA threadA = new ThreadA(publicVar);
            threadA.start();

            Thread.sleep(2000);
            publicVar.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
