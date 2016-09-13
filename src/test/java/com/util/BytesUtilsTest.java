package com.util;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

/**
 * Created by gary on 2016/9/9.
 */
public class BytesUtilsTest {
    @Test
    public void bytesToHexString() throws Exception {
        System.out.println(BytesUtils.bytesToHexString("ABab我是陈辉".getBytes()));

        try {
            String ss = new String(BytesUtils.hexStringToBytes("41426162e68891e698afe99988e8be89"),"utf-8");
            System.out.println(ss);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


}