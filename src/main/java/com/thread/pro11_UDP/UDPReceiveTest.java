package com.thread.pro11_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP协议也是传输层协议，它是无连接，不保证可靠的传输层协议
 * Created by garychen on 2017/1/20.
 */
public class UDPReceiveTest {
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket(8088);

        //2.创建数据包,用于接收内容
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);

        //3.接收数据
        socket.receive(packet);

        System.out.println("接收的数据>>");
        System.out.println(packet.getAddress().getHostAddress() + " : " + packet.getPort());

        //因为getData()返回byte[]类型数据，直接toString会将之序列化
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        //4.关闭连接
        socket.close();

    }
}
