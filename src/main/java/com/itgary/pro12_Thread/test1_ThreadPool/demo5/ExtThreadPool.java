package com.itgary.pro12_Thread.test1_ThreadPool.demo5;

import java.util.concurrent.*;

/**
 * 扩展线程池
 * 直接提交的队列
 * 有界任务队列
 * 无界的任务队列
 * 优先任务队列
 * Created by garychen on 2017/2/6.
 */
public class ExtThreadPool {

    public static class MyTask5 implements Runnable{
        private String name;

        public MyTask5(String name){
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("正在执行: " + Thread.currentThread().getId() + ", Task Name:"+ name);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService ex = new ThreadPoolExecutor(5,5,0L,
                                                    TimeUnit.MILLISECONDS,
                                                    //new SynchronousQueue<Runnable>()){        //直接提交的队列
                                                    //new ArrayBlockingQueue<Runnable>(2)){     //有界任务队列
                                                    new LinkedBlockingQueue<Runnable>()){       //无界的任务队列
                                                    //new PriorityBlockingQueue<Runnable>(){    //优先任务队列
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行: " + ((MyTask5)r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("--执行完成--: " + ((MyTask5)r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };

        for (int i = 0; i < 5; i++) {
            MyTask5 myTask5 = new MyTask5("TASK - GEYE-" + i);
            ex.execute(myTask5);
            Thread.sleep(10);
        }
        ex.shutdown();
    }
}
