package com.itgary.pro.jna;

import java.util.Arrays;

/**
 * Created by garychen on 16-8-11.
 */
public class ItestJnaUtils {
    public static ItestJna INSTANCE = ItestJna.INSTANCE;

    //public

    public static void main(String[] args) {
        byte[] b = new byte[2];
        b[0]='a';
        b[1]='b';

        System.out.println(Arrays.toString(b));

        for (int i = 0; i < 10; i++) {
            System.out.println(INSTANCE.print_str());
        }

    }
}
