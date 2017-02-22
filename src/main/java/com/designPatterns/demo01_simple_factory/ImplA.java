package com.designPatterns.demo01_simple_factory;

/**
 * Created by garychen on 2017/2/21.
 */
public class ImplA implements Api{
    @Override
    public void operation(String s) {
        System.out.println("ImplA s==" + s);
    }
}
