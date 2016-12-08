package com.itgary.pro9;

/**
 * Created by garychen on 2016/12/8.
 */
public class Test {

    @org.junit.Test
    public void test(){
        System.out.println("test....");

        IMain i = new Sub1();

        String s = i.print("hello");

        System.out.println(s);
    }
}
