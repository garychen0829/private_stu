package com.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by gary on 2016/7/19.
 */
public class MyBufferedReader {

    private Reader r;

    public MyBufferedReader(Reader r){
        this.r = r;
    }

    public String myReadLine(){
        StringBuffer sb = new StringBuffer();
        int ch = 0;
        try {
            while((ch = r.read()) != -1){
                if (ch == '\r') {
                    continue;
                }
                if (ch == '\n') {
                    return sb.toString();
                }else{
                    sb.append((char) ch);
                }
            }
            if (sb.length() != 0) {
                return sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void myclose() throws IOException {
        r.close();
    }

    public static void main(String[] args) {
        try {
            MyBufferedReader my = new MyBufferedReader(new FileReader("bf1.txt"));
            String line = null;
            while ((line = my.myReadLine()) != null){
                System.out.println(line);
                System.out.println("---------------");
            }

            my.myclose();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
