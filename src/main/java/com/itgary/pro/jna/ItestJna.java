package com.itgary.pro.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * Created by garychen on 16-8-11.
 */
public interface ItestJna extends Library {

    //gcc -fPIC -shared -g -o liba.so a.c  (编写动态库.so文件)
    //gcc -o test_1 test1.c                (编写.c文件.可执行文件)
    ItestJna INSTANCE = (ItestJna) Native.loadLibrary("linux-x86-64/a.so",ItestJna.class);
    int print_str();
}
