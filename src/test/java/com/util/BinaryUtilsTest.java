package com.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gary on 2016/9/10.
 */
public class BinaryUtilsTest {
    @Test
    public void binaryString2hexString() throws Exception {
        String bString = "1010101111001101";
        System.out.println(BinaryUtils.binaryString2hexString(bString));



    }

    @Test
    public void hexString2binaryString() throws Exception {
        //String hexString = "ABCD";
        String hexString = "49";
        System.out.println(BinaryUtils.hexString2binaryString(hexString));
    }

}