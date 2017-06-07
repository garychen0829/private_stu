package com.netty4.http_module;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by garychen on 2017/6/7.
 */
public class HttpServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss,work).channel(NioServerSocketChannel.class)
            .childHandler(new HttpServerInitializer());

        ChannelFuture future = serverBootstrap.bind(8899).sync();
        future.channel().closeFuture().sync();
    }
}
