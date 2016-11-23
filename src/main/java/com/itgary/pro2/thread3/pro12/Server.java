package com.itgary.pro2.thread3.pro12;

/**
 * Created by garychen on 2016/11/9.
 */
public class Server {

    synchronized public void server1(){
        System.out.println("A");
        server2();
    }
    synchronized public void server2(){
        System.out.println("B");
        server3();
    }
    synchronized public void server3(){
        System.out.println("C");
    }
}
