package edu.ch.jvm.custom;

import edu.ch.jvm.custom.utils.EncryptUtil;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by gary on 2017/9/5.
 */
public class TestJVMCustom {

    @Test
    public void test01_jvm_custom() throws Exception {
        File src = new File("D:\\opt\\src\\Car.class");
        File des = new File("D:\\opt\\des\\Car.class");
        EncryptUtil.encrypt(src,des);
        System.out.println("加密完成..");
    }

    @Test
    public void test02_jvm_custom() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myloader = new MyClassLoader();
        Class<?> clazz = myloader.findClass("D:\\opt\\des\\Car.class");
        System.out.println(clazz.getClassLoader());
        Object obj = clazz.newInstance();
        Method[] ms = obj.getClass().getMethods();
        for (Method method : ms) {
            System.out.println(method);
        }

        try {
            Method md = obj.getClass().getMethod("start",null);
            md.invoke(obj,null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
