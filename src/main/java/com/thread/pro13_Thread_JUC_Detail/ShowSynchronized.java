package com.thread.pro13_Thread_JUC_Detail;

/**
 * javap -v ShowSynchronized.class
 *
 *   命令说明是：输出附加信息
     class文件的路径、最后修改时间、文件大小等
     类的全路径、源（java）文件等
     常量池
     常量定义、值
     构造方法
     程序调用及执行逻辑（这个涉及的内容就比较多了）

     总之，javap -v命令是很强大的一个命令！

    http://www.cnblogs.com/frinder6/p/5440173.html
 *
 * Created by gary on 2017/3/12.
 */
public class ShowSynchronized {
    public static void main(String[] args) {
        synchronized (ShowSynchronized.class){

        }
        m();
    }

    public static synchronized void m() {

    }
}
