package com.itgary.pro2.threadStu.demo1;


import org.junit.Test;


/**
 * Created by garychen on 2016/11/2.
 */
public class TestOne {

    public static void main(String[] args) {
        System.out.println("1:"+Thread.currentThread().getName());
    }

    @Test
    public void test1() {
        System.out.println("2:"+Thread.currentThread().getName());
        System.out.println("2:"+Thread.currentThread().getContextClassLoader());
        System.out.println("2:"+Thread.currentThread().getId());
        System.out.println("2:"+Thread.currentThread().getPriority());
        System.out.println("2:"+Thread.currentThread().getState());
    }


    @Test
    public void test2(){
        Thread2 t2 = new Thread2();
        t2.run();
        System.out.println("end");
    }

    class Thread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("hello world!");
        }
    }
}
