package com.designPatterns.demo01_simple_factory;

/**
 * Created by garychen on 2017/2/21.
 */
public class Factory {
    public static Api createApi(int condition){
        Api api = null;

        if (condition == 1) {
            api = new ImplA();
        }else {
            api = new ImplB();
        }

        return api;
    }
}
