package com.netty4.demo1_callback;

/**
 * Created by garychen on 2017/5/19.
 */
public class FetcherImpl implements Fetcher {
    @Override
    public void fetchData(FetchCallback callback) {
        try {
            Data d = new Data();
            d.setName("chenh");
            d.setAge(10);
            int i = 9/0;
            callback.onData(d);
        }catch (Exception e){
            callback.onError(e);
        }

    }
}
