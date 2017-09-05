package edu.ch.jvm.custom;

import edu.ch.jvm.custom.utils.DecryptUtil;

import java.io.File;

/**
 * Created by gary on 2017/9/5.
 */
public class MyClassLoader extends ClassLoader {
    private String name;

    public MyClassLoader(){}

    public MyClassLoader(String name) {
        super();
        this.name = name;
    }


    @Override
    protected Class<?> findClass(String encFilePath) throws ClassNotFoundException {
        byte[] data = DecryptUtil.decrypt(new File(encFilePath));
        return this.defineClass(name, data, 0, data.length);
    }
}
