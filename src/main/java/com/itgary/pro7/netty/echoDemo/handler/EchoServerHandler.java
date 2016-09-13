package com.itgary.pro7.netty.echoDemo.handler;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.SocketAddress;

/**
 * Created by gary on 2016/8/4.
 */
public class EchoServerHandler extends ChannelHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        SocketAddress socketAddress = ctx.channel().remoteAddress();
        logger.info("SocketAddress socketAddress:{}",socketAddress);
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelActive");
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String)msg;
        System.out.println("Receive client: [" +msg+ "]");

    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //logger.info("channelReadComplete");
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("exceptionCaught");
        ctx.close();
    }
}
