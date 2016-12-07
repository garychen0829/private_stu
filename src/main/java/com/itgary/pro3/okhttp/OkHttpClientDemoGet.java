package com.itgary.pro3.okhttp;

import com.squareup.okhttp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * http get请求
 * Created by garychen on 2016/9/22.
 */
public class OkHttpClientDemoGet {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    OkHttpClient okHttpClient = new OkHttpClient();
    public void doOkHttpReq(){
        //http://fanyi.youdao.com/openapi.do?keyfrom=<keyfrom>&key=<key>&type=data&doctype=<doctype>&version=1.1&q=要翻译的文本
        //http://fanyi.youdao.com/openapi.do?keyfrom=gary96&key=1253068930&type=data&doctype=json&version=1.1&q=welcome
        final Request request = new Request.Builder()
                                     .url("http://fanyi.youdao.com/openapi.do?keyfrom=gary96&key=1253068930&type=data&doctype=json&version=1.1&q=welcome")
                                     .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                System.out.println("onFailure");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                System.out.println("onResponse");
                logger.info("response : {}",response);

                //1.获得返回的字符串，可以通过response.body().string()获取
                //2.获得返回的二进制字节数组，则调用response.body().bytes()；
                //3.如果想拿到返回的inputStream，则调用response.body().byteStream()
                String str = response.body().string();
                /*byte[] bytes = response.body().bytes();
                logger.info("bytes:{}",bytes);*/
                //response.body().byteStream();

                System.out.println(response.body().contentType());

                logger.info("str : {}",str);
            }
        });
    }

    public static void main(String[] args) {
        OkHttpClientDemoGet demo = new OkHttpClientDemoGet();
        demo.doOkHttpReq();
    }

}
