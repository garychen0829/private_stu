package com.itgary.pro1.stu;

import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.io.*;

/**
 * Created by gary on 2016/7/19.
 */
public class ControlInput {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("file.encoding"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("control.txt"),"utf-8"));
        String line = null;

        while ((line = bf.readLine()) != null) {
            System.out.println(line);
            bw.write(line);
            bw.newLine();
            bw.flush();

        }
        bw.close();
        bf.close();
    }
}
