package com.itgary.pro2.thread0117.test0_ThreadDetail.test_CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by garychen on 2017/1/24.
 */
public class CyclicBarrierMain {

    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        BarrierRun br = new BarrierRun(flag,N);
        CyclicBarrier cyclic = new CyclicBarrier(N,br);
        //设置障碍点.主要是为了执行这个方法
        System.out.println("集合队伍!");

        for (int i = 0; i < N; ++i) {
            System.out.println("士兵 " + i + "报道!");
            allSoldier[i] = new Thread(new Soldier(cyclic,"士兵 "+i));
            allSoldier[i].start();

        }


    }
}
