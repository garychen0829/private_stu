package com.itgary.pro2.thread3.pro10;

/**
 * Created by garychen on 2016/11/9.
 */
public class Run {

    public static void main(String[] args) {
        MyObject object = new MyObject();

        ThreadA a = new ThreadA(object);
        a.setName("A");
        ThreadB b = new ThreadB(object);
        b.setName("B");

        a.start();

        b.start();

    }


}
