package com.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gary on 2016/9/9.
 */
public class BCDUtilsTest {
    @Test
    public void bcd2Str() throws Exception {
        System.out.println(BCDUtils.bcd2Str("1213141516".getBytes()));
    }

    @Test
    public void str2Bcd() throws Exception {
        byte[] b = BCDUtils.str2Bcd("1213141516");
        System.out.println(b.length);

        for (byte bt : b){
            System.out.println("byte b: " + bt);
        }
    }

}