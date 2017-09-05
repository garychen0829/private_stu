package edu.ch.jvm.custom;

/**
 * Created by gary on 2017/9/5.
 */
public class Test1 {
    public static void main(String[] args) {
        int a = 3;
        a = a ^ 0xff;
        System.out.println("第一次异或运算后: a = " + a);
        a = a ^ 0xff;
        System.out.println("第二次异或运算后: a = " + a);

    }
}
