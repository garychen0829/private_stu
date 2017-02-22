package com.itgary.pro13_Thread_JUC_Detail;

/**
 * Created by garychen on 2017/2/20.
 */
public class Test01Volatile {

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        new Thread(demo).start();

        while (true){
            if (demo.isFlag()) {
                System.out.println("first flag:" + demo.isFlag());
                break;
            }

        }
    }
}


class ThreadDemo implements Runnable {

    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("child flag:" + flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}