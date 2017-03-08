package com.http.httpclient.demo1;

import org.junit.Test;

/**
 * Created by garychen on 2017/3/7.
 */
public class JunitHttp {

    @Test
    public void test001(){
        DoHttpGet doHttpGet = new DoHttpGet();
        doHttpGet.httpGet();
    }
}

