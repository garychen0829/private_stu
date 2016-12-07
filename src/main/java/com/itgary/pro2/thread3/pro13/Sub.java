package com.itgary.pro2.thread3.pro13;

/**
 * Created by garychen on 2016/11/9.
 */
public class Sub extends Main {
    synchronized public void operaterISubMethod(){
        try {
            while (i > 0) {
                i--;
                System.out.println("sub print i=" + i);
                Thread.sleep(100);
                super.operaterIMainMethod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
