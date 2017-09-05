package edu.ch.jvm.custom;

/**
 * Created by gary on 2017/9/5.
 */
public class Car {
    /**
     * 自定义类加载器
     * http://blog.csdn.net/TimHeath/article/details/52884482
     */
    public Car() {
        System.out.println("Car run...");
    }

    public void start(){
        System.out.println("start.....");
    }
}
