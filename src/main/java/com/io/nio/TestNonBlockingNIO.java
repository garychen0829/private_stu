package com.io.nio;


import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by garychen on 2017/4/24.
 */
public class TestNonBlockingNIO {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
        channel.configureBlocking(false);

        ByteBuffer buf = ByteBuffer.allocate(1024);
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            buf.put(str.getBytes());
            buf.flip();
            channel.write(buf);
            buf.clear();

        }
        channel.close();
    }
    /**
     * 客户端
     */
    @Test
    public void client() throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
        channel.configureBlocking(false);

        ByteBuffer buf = ByteBuffer.allocate(1024);
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            buf.put(str.getBytes());
            buf.flip();
            channel.write(buf);
            buf.clear();

        }
        channel.close();

    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel sschannel = ServerSocketChannel.open();
        sschannel.configureBlocking(false);
        sschannel.bind(new InetSocketAddress(9898));

        //获取选择器
        Selector selector = Selector.open();
        //将通道注册到选择器上,并且制定"监听接收事件"
        sschannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环获取选择器上已经"准备就绪"的事件
        while (selector.select() > 0){
            //7.获取当前选择器中所有注册的"选择键(已就绪的监听事件)"
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                //8.获取准备就绪的事件
                SelectionKey sk = it.next();
                //9.
                if (sk.isAcceptable()) {
                    //10.
                    SocketChannel schannel = sschannel.accept();
                    //11.
                    schannel.configureBlocking(false);
                    //12.
                    schannel.register(selector,SelectionKey.OP_READ);
                }else if (sk.isReadable()) {
                    SocketChannel schannel = (SocketChannel)sk.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = schannel.read(buffer)) > 0 ){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
                it.remove();
            }

        }
    }
}
