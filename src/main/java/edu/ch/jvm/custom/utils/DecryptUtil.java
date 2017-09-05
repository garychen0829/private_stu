package edu.ch.jvm.custom.utils;

import java.io.*;

/**
 * Created by gary on 2017/9/5.
 */
public class DecryptUtil {

    public static byte[] decrypt(File src)  {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(src);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int ch = 0;
            while ((ch = in.read()) != -1) {
                ch = ch ^ 0xff;
                bos.write(ch);
            }
            data = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;

    }
}
