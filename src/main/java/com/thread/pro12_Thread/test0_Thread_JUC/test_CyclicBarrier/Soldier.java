package com.thread.pro12_Thread.test0_Thread_JUC.test_CyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by garychen on 2017/1/25.
 */
public class Soldier implements Runnable {
    private String solder;
    private final CyclicBarrier cyclic;

    Soldier(CyclicBarrier cyclic, String solderName) {
        this.cyclic = cyclic;
        this.solder = solderName;

    }


    @Override
    public void run() {
        try {
            //等待所有士兵到齐
            cyclic.await();
            doWork();
            //等待所有士兵到齐
            cyclic.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    private void doWork() {
        try {
            Thread.sleep(Math.abs(new Random().nextInt() % 10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(solder + " 完成任务");

    }
}
