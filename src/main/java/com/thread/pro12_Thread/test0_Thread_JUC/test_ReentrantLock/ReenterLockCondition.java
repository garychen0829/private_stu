package com.thread.pro12_Thread.test0_Thread_JUC.test_ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**ReenterLock的Condition的对象的使用.
 * Created by garychen on 2017/1/24.
 */
public class ReenterLockCondition implements Runnable {

    public static ReentrantLock rlock = new ReentrantLock();
    public static Condition condition = rlock.newCondition();

    @Override
    public void run() {
        try {
            rlock.lock();
            condition.await();
            System.out.println("Thread is going on..");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rlock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //重入锁和Condition 对象被广泛运用到. ArrayBlockingQueue
        ReenterLockCondition reenterLockCondition = new ReenterLockCondition();

        Thread t1 = new Thread(reenterLockCondition);
        t1.start();

        Thread.sleep(2000);
        System.out.println(1);
        //通知线程t1,继续执行
        rlock.lock();
        System.out.println(2);
        condition.signal();
        System.out.println(3);
        rlock.unlock();
        System.out.println("end");
    }
}
