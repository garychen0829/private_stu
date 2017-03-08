package com.http.httpclient.okhttp;

import com.http.okhttp.OkHttpClientDemoPost;
import org.junit.Test;

import java.io.IOException;

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