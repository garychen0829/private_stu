package com.itgary.pro1.stu;

import org.junit.Test;

import java.io.*;
import java.nio.Buffer;

/**
 * Created by gary on 2016/7/19.
 */
public class BufferedStream {

    @Test
    public void test01_BufferedWriter() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("bf1.txt"));
            bw.write("chenhui bufferWriter");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02_BufferedReader(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("bf1.txt"));
            String line = null;
            while((line = br.readLine())!=null) {
                System.out.println(line);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void test03_BufferedCopyFile(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("demo2.txt"));
            BufferedReader br = new BufferedReader(new FileReader("bf1.txt"));

            String line = null;
            while ((line = br.readLine()) != null){
                bw.write(line);

                bw.newLine();

                bw.flush();
            }

            bw.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
