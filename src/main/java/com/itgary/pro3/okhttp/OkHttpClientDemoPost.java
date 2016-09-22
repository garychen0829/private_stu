package com.itgary.pro3.okhttp;

import com.squareup.okhttp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.tags.Param;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by gary on 2016/9/22.
 */
public class OkHttpClientDemoPost {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    OkHttpClient mOkHttpClient = new OkHttpClient();

    public void doOkHttpReq() throws IOException {

        String url = " http://fanyi.youdao.com/openapi.do";
        //String params = "keyfrom=gary96&key=1253068930&type=data&doctype=json&version=1.1&q=welcome";
        Param params = new Param();

        Request request = buildPostRequest(url,params);
        Call call =  mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                logger.info("Response:{}",response.body().string());
            }
        });

    }

    public Request buildPostRequest(String url, Param params){
        FormEncodingBuilder builder = new FormEncodingBuilder();
        builder.add("keyfrom","gary96");
        builder.add("key","1253068930");
        builder.add("type","data");
        builder.add("doctype","json");
        builder.add("version","1.1");
        builder.add("q","hello");

        Request req = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();

        return req;
    }


    public static void main(String[] args) {
        OkHttpClientDemoPost post = new OkHttpClientDemoPost();
        try {
            post.doOkHttpReq();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
