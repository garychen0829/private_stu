package com.itgary.pro10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by garychen on 2016/12/30.
 */
public class SocketTest {
    public static void main(String[] args) {
        try(Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13)) {
            s.setSoTimeout(3000);
            InputStream inputStream = s.getInputStream();
            Scanner in = new Scanner(inputStream);
            while (in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String execute(String host, int port, String request) {
        long begin = System.currentTimeMillis();
        try {

            Socket socket = new Socket(host, port);
            System.out.println("send+++++++++++>");
            System.out.println("请求字符串："+request);
            //打开输出流
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            //发送字节数组流长度
            output.writeInt(request.getBytes("utf-8").length);
            //发送字节数组流内容
            output.write(request.getBytes("utf-8"));
            output.flush();
            //打开输入流
            DataInputStream input = new DataInputStream(socket.getInputStream());
            int length = input.readInt();
            byte[] bytes = new byte[length];
            //读取服务端返回的字节数组流
            input.readFully(bytes, 0, length);
            long end =System.currentTimeMillis();
            System.out.println("total time:" + (end - begin) + "ms");

            if(socket != null){
                input.close();
                socket.close();
            }

            return new  String(bytes,"UTF-8");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return null;
    }



}
