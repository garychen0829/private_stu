package com.itgary.pro9;

import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by garychen on 2016/12/8.
 */
public class Test {

    @org.junit.Test
    public void test(){
        System.out.println("test....");

        IMain i = new Sub1();

        String s = i.print("hello");

        System.out.println(s);
    }

    public static void main(String[] args) {
        System.out.println("hello 1219...");
    }


    public void sayHi(@RequestBody Object obj){
        JavaBean javaBean = new JavaBean();
        javaBean.setName("a");
        javaBean.getName();

    }

    class JavaBean{
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
