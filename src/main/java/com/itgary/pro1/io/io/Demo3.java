package com.itgary.pro1.io.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by garychen on 2017/1/20.
 */
public class Demo3 {
    //一次读一个字符.
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("demo.txt");
            int ch = 0;

            while ((ch=fr.read())!=-1){
                //System.out.println(ch);
                System.out.println(ch + "====" + (char) ch);
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
