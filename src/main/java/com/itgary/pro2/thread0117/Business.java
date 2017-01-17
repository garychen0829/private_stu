package com.itgary.pro2.thread0117;

/**
 * Created by garychen on 2017/1/17.
 */
public class Business {
    boolean bShouldSub = true;//这里相当于定义了控制该谁执行的一个信号灯

    public synchronized void MainThread(int i) {
        if (bShouldSub)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        for (int j = 0; j < 5; j++) {
            System.out.println(Thread.currentThread().getName() + ":i=" + i + ",j=" + j);
        }
        bShouldSub = true;
        this.notify();

    }


    public synchronized void SubThread(int i) {
        if (!bShouldSub)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        for (int j = 0; j < 10; j++) {
            System.out.println(Thread.currentThread().getName() + ":i=" + i + ",j=" + j);
        }
        bShouldSub = false;
        this.notify();
    }
}
