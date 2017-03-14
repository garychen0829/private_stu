package com.itgary.pro.callb;

import java.util.logging.Logger;

/**
 * Created by garychen on 2017/3/13.
 */
public class MethodB {
    public double getTime(CallBackInterface callback) {
        long start = System.currentTimeMillis();
        callback.executeMethod();
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start));
        return end - start;
    }
}
