package com.itgary.pro2.thread3.pro13;

/**
 * Created by garychen on 2016/11/9.
 */
public class Main {

    public int i = 10;

    synchronized public void operaterIMainMethod(){
        try {
            i--;
            System.out.println("main print i=" + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
