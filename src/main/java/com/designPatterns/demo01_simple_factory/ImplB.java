package com.designPatterns.demo01_simple_factory;

/**
 * Created by garychen on 2017/2/21.
 */
public class ImplB implements Api{
    @Override
    public void operation(String s) {
        System.out.println("ImplB s==" + s);
    }
}
