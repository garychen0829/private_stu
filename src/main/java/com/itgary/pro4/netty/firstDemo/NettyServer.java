package com.itgary.pro4.netty.firstDemo;

import com.itgary.pro4.netty.firstDemo.handler.TimeServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by gary on 2016/8/4.
 */
//@Component
//@Scope("singleton")
public class NettyServer implements InitializingBean,DisposableBean {
    private static Logger logger = LoggerFactory.getLogger(NettyServer.class);

    public void bind(int port) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGrp = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            bootstrap.group(bossGroup, workerGrp)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>(){
                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
//                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new TimeServerHandler());
                        }
                    });


            ChannelFuture future = bootstrap.bind(port).sync();


            future.channel().closeFuture().addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {

                    if (future.isSuccess()) {
                        logger.info("### Server started" + future.channel() );
                        logger.info("bind netty server:");
                    } else {
                        logger.error("### Server started failed");
                    }
                }
            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            System.out.println("close netty server");
//            bossGroup.shutdownGracefully();
//            workerGrp.shutdownGracefully();
        }
    }

    public void afterPropertiesSet() throws Exception {
        logger.info("====init spring.===={}","bind(10080)");
        //bind(10080);
    }

    public void destroy() throws Exception {

    }
}
