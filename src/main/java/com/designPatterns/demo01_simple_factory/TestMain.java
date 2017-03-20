package com.designPatterns.demo01_simple_factory;

/**
 * Created by garychen on 2017/2/21.
 */
public class TestMain {

    public static void main(String[] args) {
        Api api = Factory.createApi(2);
        api.operation("正在使用简单工厂");
    }
}
