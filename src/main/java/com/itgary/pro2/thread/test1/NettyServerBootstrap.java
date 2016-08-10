package com.itgary.pro2.thread.test1;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.apache.log4j.Logger;


/**
 * Created by gary.chen on 2016/4/8.
 */
public class NettyServerBootstrap {
    private static Logger logger = Logger.getLogger(NettyServerBootstrap.class);

    private int port;

    NettyServerBootstrap(int port){
        this.port = port;
        bind();
    }

    private void bind() {
        logger.info("=======================================begin");
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        logger.info("=======================================  end");
    }

    public static void main(String[] args){
       System.out.println("test main");
        NettyServerBootstrap netty = new NettyServerBootstrap(8080);
    }
}
