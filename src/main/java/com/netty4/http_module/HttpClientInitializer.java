package com.netty4.http_module;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;

/**
 * Created by garychen on 2017/6/7.
 */
public class HttpClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new HttpResponseDecoder());
        ch.pipeline().addLast(new HttpRequestEncoder());
        ch.pipeline().addLast(new HttpClientHanlder());
    }
}
