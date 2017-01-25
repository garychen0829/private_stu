package com.itgary.pro2.thread0117.test_CyclicBarrier;

/**
 * Created by garychen on 2017/1/25.
 */
public class BarrierRun implements Runnable{
    boolean flag;
    int N;

    public BarrierRun(boolean flag, int N){
        this.flag = flag;
        this.N = N;
    }

    @Override
    public void run() {
        if (flag) {
            System.out.println("司令: 士兵 " + N + "个,任务完成");
        }else {
            System.out.println("司令: 士兵 " + N + "个,集合完毕!");
            flag = true;
        }
    }

}
