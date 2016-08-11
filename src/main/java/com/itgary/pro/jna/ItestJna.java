package com.itgary.pro.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * Created by garychen on 16-8-11.
 */
public interface ItestJna extends Library {

    //gcc -fPIC -shared -g -o liba.so a.c
    ItestJna INSTANCE = (ItestJna) Native.loadLibrary("linux-x86-64/a.so",ItestJna.class);
    int print_str();
}
