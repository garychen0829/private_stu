package com.http.httpclient.demo2;

import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by garychen on 2017/3/7.
 */
public class TestHttpGet {

    @Test
    public void test001() throws URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();
        /*
        //方法一
        String uri = "http://fanyi.youdao.com/openapi.do?keyfrom=gary96&key=1253068930&type=data&doctype=json&version=1.1&q=welcome";
        */

        //方法二
//        try {
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("fanyi.youdao.com")
                .setPath("/openapi.do")
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

        response.addHeader("Set-Cookie","c1=a; path=/; domain=localhost");
        response.addHeader("Set-Cookie","c2=b; path=\"/\", c3=c; domain=\"localhost\"");
        Header h1 = response.getFirstHeader("Set-Cookie");
        System.out.println("Header h1 = response.getFirstHeader:"+h1);
        Header h2 = response.getLastHeader("Set-Cookie");
        System.out.println("Header h2 = response.getLastHeader:"+h2);
        Header[] hs = response.getHeaders("Set-Cookie");
        System.out.println(hs.length);

        //方案一
        //CloseableHttpResponse response1 = client.execute(httpGet);
        //System.out.println(EntityUtils.toString(response.getEntity(),"utf-8"));

        //方案二

//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //方法2
        //the most efficient way to obtain all headers of a given type is by using the HeaderIterator interface.
        HeaderIterator headerIterator = response.headerIterator();
        while (headerIterator.hasNext()){
            System.out.println(headerIterator.next());
        }

        //方法3
        HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator("Set-Cookie"));
        while (it.hasNext()){
            HeaderElement element = it.nextElement();
            System.out.println(element.getName() + ">" + element.getValue());

            NameValuePair[] params = element.getParameters();

            for (int i = 0; i < params.length; i++) {
                System.out.println(">>>" + params[i]);
            }

        }

    }

}
