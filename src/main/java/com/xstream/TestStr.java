package com.xstream;

import com.xstream.bean.Student;
import org.junit.Test;

/**
 * Created by garychen on 2017/5/19.
 */
public class TestStr {

    @Test
    public void test() {


        for (int i = 0; i < 100; i++) {
            System.out.println(String.format("%012d", i));
        }

        //String.format("%012d", 1);


    }
}
