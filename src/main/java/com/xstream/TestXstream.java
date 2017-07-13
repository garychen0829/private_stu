package com.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.xstream.bean.Student;
import com.xstream.bean.TeacherBean;
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
        xstream.alias("student", Student.class);                    //对象节点(类混叠)
        //xstream.useAttributeFor(Student.class, "name");
        xstream.aliasField("aaa", Student.class, "age");
//        xstream.aliasField("name", Student.class, "name");   //字段节点(字段混叠)
        xstream.addImplicitCollection(Student.class, "age");      //隐式集合混叠
        Student student = new Student();
        student.setName("gary");
        //student.setAge(27);

        String xml = xstream.toXML(student);
        System.out.println(">>>"+xml);
//        System.out.println("===========================================");
        System.out.println(formatXml(xml));

        System.out.println();
        System.out.println();
        System.out.println();

        //XML to Object Conversion
        Student student1 = (Student)xstream.fromXML(xml);
        System.out.println("json: "+student1);

        System.out.println("===========================================注解方式好像不好用,猜测要配置环境变量");
//        //注解方式
//        TestXstream testXstream = new TestXstream();
//        TeacherBean teacherBean = testXstream.getTeacher();
//
//        xml = xstream.toXML(teacherBean);
//
//        System.out.println(xml);
//        System.out.println("############################################");

        String xml1 = "<?xml version=\"1.0\" ?><student><studentName>aa</studentName><age>27</age></student>";
        System.out.println();
        Student student2 = (Student)xstream.fromXML(xml1);
//
//        System.out.println(student2.toString());
//        String name = student2.getName().replace("\\","/");
//        System.out.println(name);

    }


    public TeacherBean getTeacher(){
        TeacherBean teacherBean = new TeacherBean();
        teacherBean.setTeachName("chenhui");
        teacherBean.setTeachAge(8);

        return teacherBean;
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
