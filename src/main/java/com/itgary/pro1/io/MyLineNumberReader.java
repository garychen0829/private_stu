package com.itgary.pro1.io;

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

//    public static void main(String[] args) {
//        try {
//            String fileName = "E:\\home\\sh_app\\opt\\provider-account\\tradefile\\PDS_200191000004387_20170322.txt";
//            MyLineNumberReader my = new MyLineNumberReader(new FileReader(fileName));
////            MyLineNumberReader my = new MyLineNumberReader(new FileReader("bf1.txt"));
//            String line = null;
//            while ((line = my.myReadLine()) != null){
//                System.out.println("line num:" + my.getNumber() + "  msg:" +line);
//
//                if (my.getNumber() >= 2) {//
//                    String[] values = line.split(" ");
//                    System.out.println("size : " + values.length);
//                    System.out.println(values[0]);
//                    System.out.println(values[1]);
//                    System.out.println(values[2]);
//                    System.out.println(values[3]);
//                    System.out.println(values[4]);
//                    System.out.println(values[5]);
//                    System.out.println(values[6]);
//                    System.out.println(values[7]);
//                }
//            }
//            my.myclose();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
