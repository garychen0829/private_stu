package com.itgary.pro2.thread3.pro10;

/**
 * Created by garychen on 2016/11/9.
 */
public class MyObject {
    synchronized public void methodA(){

        try {
            System.out.println("AAAAAAAAAAAA");
            Thread.sleep(3000);
            System.out.println("end A");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    synchronized public void methodB(){
        try {
            System.out.println("BBBBBBBBBBBB");
            Thread.sleep(3000);
            System.out.println("end B");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
