package com.itgary.pro9;

/**
 * Created by garychen on 2016/12/8.
 */
public class Sub1 extends Main{
    @Override
    protected boolean iftrue(boolean a) {
        return a;
    }

    @Override
    protected String sayHello(String type) {
        return "hello sub1";
    }


    @Override
    public String print(String s) {
        return "sub1:"+s;
    }
}
