package com.itgary.pro4.netty.firstDemo.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.SocketAddress;
import java.util.Date;

/**
 * Created by gary on 2016/8/4.
 */
public class TimeServerHandler extends ChannelHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private int count;

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        SocketAddress socketAddress = ctx.channel().remoteAddress();
        logger.info("SocketAddress socketAddress:{}",socketAddress);
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelActive");
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("TimeServerHandler channelRead 1,{}", msg);

        ByteBuf buf = (ByteBuf)msg;

        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req,"UTF-8").substring(0,req.length - System.getProperty("line.separator").length());
        logger.info("###netty server recv###: " + body);

        logger.info("The time server receive order: " + body + "; the count is: " + ++count);

        String curtime = new Date(System.currentTimeMillis()).toString();
        //ByteBuf resp = Unpooled.copiedBuffer((curtime+"=========abcdefg").getBytes());
        ByteBuf resp = Unpooled.copiedBuffer(body.getBytes());

        ctx.writeAndFlush(resp);

    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelReadComplete");
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("exceptionCaught");
        ctx.close();
    }
}
