package com.io;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by gary on 2016/7/19.
 */
public class FileWriter1 {

    @Test
    public void test01_fileWriter(){
        try {
            FileWriter fileWriter = new FileWriter("demo1.txt");
            fileWriter.write("i am a good man !\n");
            fileWriter.flush();
            fileWriter.write("----------------this is a test..");
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test02_fileWriter(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("F:\\IDEA_PRO\\demo2.txt");
            fileWriter.write("abcdefg");
            fileWriter.flush();
            fileWriter.write("====kkkkkkk");


        } catch (IOException e) {
            System.out.println(e.toString());
            //e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("close:"+e.toString());
                }
            }
        }
    }
}
