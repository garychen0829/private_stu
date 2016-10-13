package com.itgary.pro3.okhttp;

import com.squareup.okhttp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.tags.Param;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by gary on 2016/9/22.
 */
public class OkHttpClientDemoPost {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    OkHttpClient mOkHttpClient = new OkHttpClient();

    public void doOkHttpReq() throws IOException, InterruptedException {

        final CountDownLatch latch = new CountDownLatch(1);

        String url = " http://fanyi.youdao.com/openapi.do";
        //String params = "keyfrom=gary96&key=1253068930&type=data&doctype=json&version=1.1&q=welcome";
        Map map = new HashMap();
        map.put("keyfrom","gary96");
        map.put("key","1253068930");
        map.put("type","data");
        map.put("doctype","json");
        map.put("version","1.1");
        map.put("q","hello");


        Request request = buildPostRequest(url,map);
        Call call =  mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                latch.countDown();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                latch.countDown();
                logger.info("Response:{}",response.body().string());
            }
        });
        latch.await();
    }

    public Request buildPostRequest(String url, Map<String,String> map){
        FormEncodingBuilder builder = new FormEncodingBuilder();

        for (Map.Entry<String,String> mEntry : map.entrySet()) {
            logger.debug("out print, key[{}],value[{}] : " , mEntry.getKey() ,mEntry.getValue());
            builder.add(mEntry.getKey(),mEntry.getValue());
        }

//        builder.add("keyfrom","gary96");
//        builder.add("key","1253068930");
//        builder.add("type","data");
//        builder.add("doctype","json");
//        builder.add("version","1.1");
//        builder.add("q","hello");

        Request req = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();

        return req;
    }


}
