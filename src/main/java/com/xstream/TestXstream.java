package com.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.xstream.bean.Student;
import org.xml.sax.InputSource;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by garychen on 2017/4/27.
 */
public class TestXstream {

    public static void main(String[] args) {
        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("student", Student.class);
        Student student = new Student();
        student.setName("gary");
        student.setAge(27);

        String xml = xstream.toXML(student);
        System.out.println(xml);
        System.out.println(formatXml(xml));
        //XML to Object Conversion
        Student student1 = (Student)xstream.fromXML(xml);
        System.out.println(student1);
    }


    /**
     * xml格式化
     * @param xml
     * @return
     */
    public static String formatXml(String xml){
        try{
            Transformer serializer= SAXTransformerFactory.newInstance().newTransformer();
            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
            serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            Source xmlSource=new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes())));
            StreamResult res =  new StreamResult(new ByteArrayOutputStream());
            serializer.transform(xmlSource, res);
            return new String(((ByteArrayOutputStream)res.getOutputStream()).toByteArray());
        }catch(Exception e){
            return xml;
        }
    }

}
