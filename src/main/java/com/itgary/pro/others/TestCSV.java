package com.itgary.pro.others;

import com.csvreader.CsvReader;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gary.chen on 2016/7/5.
 */
public class TestCSV {

    @Test
    public void tcsv(){
        String filePath = "E:\\csv\\Junit.csv";
        List list = generateCSV(filePath);
        for (int i = 0; i < list.size(); i++) {
            String st = list.get(i).toString();
            System.out.println(st);

            String[] str = st.split(",");
            for (int j = 0; j < str.length; j++) {
                String val = str[j];
                System.out.println(" - " + val);
            }
        }
    }

    public static List generateCSV(String filePath) {
        //生成CsvReader对象，以，为分隔符，GBK编码方式
        List list = new LinkedList();
        CsvReader r = null;
        try {
            r = new CsvReader(filePath, ',', Charset.forName("GBK"));
            //读取表头
            r.readHeaders();
            //逐条读取记录，直至读完
            while (r.readRecord()) {
                System.out.println("r.getRawRecord():"+r.getRawRecord());
                list.add(r.getRawRecord());
                //按列名读取这条记录的值
//                System.out.println(r.get("Name"));
//                System.out.println(r.get("class"));
//                System.out.println(r.get("number"));
//                System.out.println(r.get("sex"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        r.close();
        return list;
    }
}
