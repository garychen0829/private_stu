package com.netty4.http_module;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;

/**
 * Created by garychen on 2017/6/7.
 */
public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // server端发送的是httpResponse，所以要使用HttpResponseEncoder进行编码
        //channel.pipeline().addLast(new HttpResponseEncoder());
        // server端接收到的是httpRequest，所以要使用HttpRequestDecoder进行解码
        channel.pipeline().addLast(new HttpRequestDecoder());
        channel.pipeline().addLast(new HttpServerHanlder());

    }
}
