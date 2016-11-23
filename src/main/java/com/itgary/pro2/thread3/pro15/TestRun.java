package com.itgary.pro2.thread3.pro15;

/**
 * Created by garychen on 2016/11/9.
 */
public class TestRun {

    public static void main(String[] args) {
        Sub sub = new Sub();
        MyThreadA a = new MyThreadA(sub);
        a.setName("A");
        a.start();

        MyThreadB b = new MyThreadB(sub);
        b.setName("B");
        b.start();

    }
}
