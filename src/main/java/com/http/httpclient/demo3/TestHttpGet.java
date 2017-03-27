package com.http.httpclient.demo3;

import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by garychen on 2017/3/7.
 */
public class TestHttpGet {

    @Test
    public void test001() throws URISyntaxException {
        //方法二
        //https://tlt.allinpay.com
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("tlt.allinpay.com")
                .setPath("/aipg/ProcessServlet")
                .setParameter("keyfrom", "gary96")
                .setParameter("key", "1253068930")
                .setParameter("type", "data")
                .setParameter("doctype", "json")
                .setParameter("version", "1.1")
                .setParameter("q", "welcome")
                .build();

        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");


        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
        System.out.println(response.getProtocolVersion());
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getReasonPhrase());
        System.out.println(response.getStatusLine().toString());



    }

}
