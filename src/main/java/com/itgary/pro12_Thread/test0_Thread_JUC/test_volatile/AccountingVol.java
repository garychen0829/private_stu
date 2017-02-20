package com.itgary.pro12_Thread.test0_Thread_JUC.test_volatile;

/**
 * Created by garychen on 2017/1/23.
 */
public class AccountingVol implements Runnable{
    static AccountingVol ins = new AccountingVol();
    static int i = 0;

    public static synchronized void ins(){
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            synchronized (ins){
                ins();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(ins,"a");
        Thread t2 = new Thread(ins,"b");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
