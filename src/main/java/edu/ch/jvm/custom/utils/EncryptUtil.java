package edu.ch.jvm.custom.utils;

import java.io.*;

/**
 * Created by gary on 2017/9/5.
 */
public class EncryptUtil {

    public static void encrypt(File src, File des) throws Exception {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(des);
        int ch;
        while ((ch = in.read()) != -1){
            ch = ch ^ 0xff;//可参照edu.ch.jvm.custom.Test1中的例子
            out.write(ch);
        }
        in.close();
        out.close();
    }

    public static void decrypt(){

    }
}
