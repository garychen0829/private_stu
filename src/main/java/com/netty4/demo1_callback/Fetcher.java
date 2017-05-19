package com.netty4.demo1_callback;

/**
 * Created by garychen on 2017/5/19.
 */
public interface Fetcher {
    void fetchData(FetchCallback callback);

}
