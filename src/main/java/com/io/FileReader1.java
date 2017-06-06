package com.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by gary on 2016/7/19.
 */
public class FileReader1 {

    @Test
    public void test01_FileReader(){
        FileReader fr = null;
        try {
            fr = new FileReader("demo1.txt");
            char[] ch = new char[1024];

            int len = 0;
            int index = 0;
            while((len =  fr.read(ch)) != -1){
                System.out.println("index : "+ (index++));
                System.out.println(new String(ch,0,len));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}