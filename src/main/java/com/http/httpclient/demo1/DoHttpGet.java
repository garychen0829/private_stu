package com.http.httpclient.demo1;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URL;

/**
 * 网易云课堂.
 * 无参的get请求
 * Created by garychen on 2017/3/6.
 */
public class DoHttpGet{

    private String URL = "http://www.ip.cn/index.php";
    public void httpGet(){
        //1.新建httpclient
        CloseableHttpClient client = HttpClients.createDefault();
        //2.选择get请求
        HttpGet httpGet = new HttpGet(URL);
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");

        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);

            System.out.println(response.getStatusLine());

            HttpEntity httpEntity = response.getEntity();
            if (null != httpEntity) {
                httpEntity.getContentLength();

                System.out.println(EntityUtils.toString(httpEntity,"utf-8"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
