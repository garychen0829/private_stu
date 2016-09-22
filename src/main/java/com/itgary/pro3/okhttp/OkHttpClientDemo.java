package com.itgary.pro3.okhttp;

import com.squareup.okhttp.*;
import com.squareup.okhttp.internal.http.RealResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by garychen on 2016/9/22.
 */
public class OkHttpClientDemo {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    OkHttpClient okHttpClient = new OkHttpClient();
    public void okHttpReq(){
        final Request request = new Request.Builder()
                                     .url("http://fanyi.youdao.com/openapi.do?keyfrom=private-stu-okhttp&key=788633767&type=data&doctype=json&version=1.1&q=你好")
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

                RealResponseBody realResponseBody = (RealResponseBody) response.body();
                logger.info("response : {}",realResponseBody);
            }
        });
    }

    public static void main(String[] args) {
        OkHttpClientDemo demo = new OkHttpClientDemo();
        demo.okHttpReq();
    }

}
