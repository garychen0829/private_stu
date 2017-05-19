package com.netty4.demo1_callback;

/**
 * Created by garychen on 2017/5/19.
 */
public class Worder {

    public void work(){
        Fetcher fetcher = new FetcherImpl();
        fetcher.fetchData(new FetchCallback() {
            @Override
            public void onData(Data data) {
                System.out.println("Data received: " + data.toString());
            }

            @Override
            public void onError(Throwable cause) {
                System.err.println("An error accour: " + cause.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        Worder w = new Worder();
        w.work();
    }

}
