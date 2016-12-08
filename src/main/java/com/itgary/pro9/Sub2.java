package com.itgary.pro9;

/**
 * Created by garychen on 2016/12/8.
 */
public class Sub2 extends Main{
    @Override
    protected boolean iftrue(boolean b) {
        return b;
    }

    @Override
    protected String sayHello(String type) {
        return "hello sub2";
    }

    @Override
    public String print(String s) {
        return "sub2:"+s;
    }
}
