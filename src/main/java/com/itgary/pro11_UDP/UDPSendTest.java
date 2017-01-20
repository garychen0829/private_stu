package com.itgary.pro11_UDP;

import java.io.IOException;
import java.net.*;

/**
 * UDP的通信
 * Created by garychen on 2017/1/20.
 */
public class UDPSendTest {

    public static void main(String[] args) throws IOException {
        //1、创建DatagramSocket用于UDP数据传送。
        DatagramSocket socket = new DatagramSocket();

        //2、创建需要发送的数据包
        byte[] buf = "Hello World.".getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 8088);

        //3、发送
        socket.send(packet);

        //4、关闭连接
        socket.close();


    }
}
