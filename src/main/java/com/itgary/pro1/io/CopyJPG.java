package com.itgary.pro1.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by gary on 2016/7/19.
 */
public class CopyJPG {

    @Test
    public void copy(){
        try {
            BufferedInputStream bufins = new BufferedInputStream(new FileInputStream("IMG_2207.JPG"));
            BufferedOutputStream bufout = new BufferedOutputStream(new FileOutputStream("copy_IMG_2207.jpg"));

            int by = 0;

            while ((by = bufins.read())!=-1 ){
                bufout.write(by);
            }
            bufout.flush();
            bufout.close();
            bufins.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
