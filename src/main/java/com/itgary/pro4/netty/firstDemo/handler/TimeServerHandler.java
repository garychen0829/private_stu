package com.itgary.pro4.netty.firstDemo.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by gary on 2016/8/4.
 */
public class TimeServerHandler extends ChannelHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelActive");
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("channelRead");

        ByteBuf buf = (ByteBuf)msg;

        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req,"UTF-8");
        System.out.println("netty server recv:" + body);

        String curtime = new Date(System.currentTimeMillis()).toString();
        ByteBuf resp = Unpooled.copiedBuffer(curtime.getBytes());
        ctx.write(resp);

    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelRead");
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("exceptionCaught");
        ctx.close();
    }
}
