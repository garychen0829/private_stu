package com.itgary.pro1.io.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by garychen on 2017/1/20.
 */
public class Demo2 {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("F:\\demo.txt");
            fw.write("asdfg");
            fw.flush();
            fw.write("kkkkk");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(e.toString());
                }
            }
        }

    }
}
