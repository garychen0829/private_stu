package com.itgary.pro1.io.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by garychen on 2017/1/20.
 */
public class Demo2 {
    public static void main(String[] args) {
        String filePath = "F:\\demo.txt"; //方式1:把单\ 替换成\\
//        filePath = "F:/demo.txt";         //方式2:把"\\"斜杠 替换成 "/"
        String str = "\\";

        str = str.replace("\\","/"); //"\\\\" 双斜杠的写法是四个斜杠. replaceAll是替换字符串

        System.out.println(str);

//        FileWriter fw = null;
//        try {
//            fw = new FileWriter(filePath);
//            fw.write("asdfg");
//            fw.flush();
//            fw.write("kkkkk");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println(e.toString());
//        } finally {
//            if (fw != null) {
//                try {
//                    fw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    System.out.println(e.toString());
//                }
//            }
//        }

    }
}
