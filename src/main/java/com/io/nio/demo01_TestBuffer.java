package com.io.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Created by garychen on 2017/6/25.
 */
public class demo01_TestBuffer {

    @Test
    public void test_buffer(){
        //1.分配一个指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] str = "hello".getBytes();
        System.out.println("=====allocate()=====");
        System.out.println("1容量: " + buffer.capacity() + "界限: " + buffer.limit() + "位置: " + buffer.position() + "标记: " + buffer.mark());


        //2利用put(),存放byte[] 数组
        buffer.put(str);
        System.out.println("=====put()=====");
        System.out.println("2容量: " + buffer.capacity() + "界限: " + buffer.limit() + "位置: " + buffer.position() + "标记: " + buffer.mark());

        //3切换模式,从写->读
        buffer.flip();
        System.out.println("=====flip()=====");
        System.out.println("3容量: " + buffer.capacity() + "界限: " + buffer.limit() + "位置: " + buffer.position() + "标记: " + buffer.mark());

        //4.利用get(),读取缓冲区的数据
        byte[] dist = new byte[buffer.limit()];
        buffer.get(dist);
        System.out.println("=====get()=====");
        System.out.println("4容量: " + buffer.capacity() + "界限: " + buffer.limit() + "位置: " + buffer.position() + "标记: " + buffer.mark());

        //5.rewind(),可重复读数据.
        buffer.rewind();
        System.out.println("=====rewind()=====");
        System.out.println("5容量: " + buffer.capacity() + "界限: " + buffer.limit() + "位置: " + buffer.position() + "标记: " + buffer.mark());

        //6.clear(),情况缓冲区,但是缓冲区的数据依然存在,但是出于"被遗忘"状态
        buffer.clear();
        System.out.println("=====clear()=====");
        System.out.println("6容量: " + buffer.capacity() + "界限: " + buffer.limit() + "位置: " + buffer.position() + "标记: " + buffer.mark());
        System.out.println("但是缓冲区的数据依然存在,但是出于\"被遗忘\"状态: "+(char)buffer.get());

        buffer.get(dist,0,2);

        System.out.println(new String(dist,0,2));

        System.out.println("=====get()=====");
        System.out.println("7容量: " + buffer.capacity() + "界限: " + buffer.limit() + "位置: " + buffer.position() + "标记: " + buffer.mark());

        //maker标记
        buffer.mark();
        buffer.get(dist,2,2);
        System.out.println(new String(dist,2,2));
        System.out.println(buffer.position());

        //reset(): 恢复到mark标记位
        //buffer.reset();
        System.out.println(buffer.position());

        if (buffer.hasRemaining()) {
            //获取缓冲区中可以操作的数量.
            System.out.println("获取缓冲区中可以操作的数量."+buffer.remaining());

        }

    }
}
