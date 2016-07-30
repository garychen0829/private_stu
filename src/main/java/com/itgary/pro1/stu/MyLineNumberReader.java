package com.itgary.pro1.stu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by gary on 2016/7/19.
 */
public class MyLineNumberReader extends MyBufferedReader{

    private int number;
    public MyLineNumberReader(Reader r) {
        super(r);
    }

    public String myReadLine(){
        number++;
        return super.myReadLine();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        try {
            MyLineNumberReader my = new MyLineNumberReader(new FileReader("bf1.txt"));
            String line = null;
            while ((line = my.myReadLine()) != null){
                System.out.println("line num:" + my.getNumber() + "  msg:" +line);
            }
            my.myclose();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
