package com.thread.pro12_Thread.demo1.go;

/**
 * Created by garychen on 2017/1/17.
 */
public class ExeThread {

    public boolean flag = true;

    public synchronized void mainThread(int i) {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int j = 1 ; j <= 10; j++) {
            System.out.println("main 打印: [" + i+","+j + "] 次.");
        }

        flag = true;

        this.notify();
    }

    public synchronized void subThread(int i) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j < 5; j++) {
            System.out.println("sub 打印: [" + i+","+j + "] 次.");
        }

        flag = false;

        this.notify();
    }
}
