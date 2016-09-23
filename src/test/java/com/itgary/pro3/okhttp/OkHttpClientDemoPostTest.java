package com.itgary.pro3.okhttp;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by garychen on 2016/9/23.
 */
public class OkHttpClientDemoPostTest {

    @Test
    public void testDoOkHttpReq() throws Exception {
        OkHttpClientDemoPost post = new OkHttpClientDemoPost();
        try {
            post.doOkHttpReq();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}