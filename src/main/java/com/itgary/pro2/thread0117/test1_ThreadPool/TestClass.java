package com.itgary.pro2.thread0117.test1_ThreadPool;

/**
 * Created by garychen on 2017/2/6.
 */
public class TestClass {



    public static void main(String[] args) {

        //内部类在局部位置上,只能访问局部中被final修饰的局部变量
        final int i = 0;

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(i);
            }
        });

        t.start();
    }
}
