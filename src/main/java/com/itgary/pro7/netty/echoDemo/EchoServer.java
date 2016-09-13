package com.itgary.pro7.netty.echoDemo;


import com.itgary.pro7.netty.echoDemo.handler.EchoServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by gary on 2016/8/4.
 */
@Component
@Scope("singleton")
public class EchoServer implements InitializingBean,DisposableBean {
    private static Logger logger = LoggerFactory.getLogger(EchoServer.class);

    public void bind(int port) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGrp = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGrp)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new FixedLengthFrameDecoder(20));
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new EchoServerHandler());

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
        logger.info("====init spring.===={FixedLengthFrameDecoder}","bind(10080) start");
        bind(10080);
        logger.info("====init spring.===={FixedLengthFrameDecoder}","bind(10080) end..");
    }

    public void destroy() throws Exception {

    }
}
