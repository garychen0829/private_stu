package com.netty4.http_module;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by garychen on 2017/6/7.
 */
public class HttpClient {

    public static void main(String[] args) throws Exception {
        EventLoopGroup work = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(work)
                .channel(NioSocketChannel.class)
                .handler(new HttpClientInitializer());
        ChannelFuture future = bootstrap.connect("127.0.0.1",8899).sync();
        future.channel().closeFuture().sync();

    }
}
