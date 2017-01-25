package com.itgary.pro1.io.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 将文本数据存储到一个文件中
 * Created by garychen on 2017/1/19.
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("demo.txt");
        fw.write("abcdefg");
        fw.flush();
        fw.write("zzzzzzz");
        fw.close();
    }
}
