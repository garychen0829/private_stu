package com.itgary.pro2.thread.my_runnabele.test1;

/**
 * Created by gary.chen on 2016/4/12.
 */
public class MyThread extends Thread {
    private int count = 5;

    public MyThread(String name){
        super();
        this.setName(name);//设置线程名称
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + this.getName() + "开始计算," + count);
        }
    }
}
