package com.thread.pro12_Thread.test1_ThreadPool.demo6;

import java.util.concurrent.*;

/**
 * 在线程池中寻找堆栈 1
 * Created by garychen on 2017/2/6.
 */
public class DivTask implements Runnable{

    int a;
    int b;

    public DivTask(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double r = a/b;
        System.out.println(r);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pools = new ThreadPoolExecutor(0,Integer.MAX_VALUE,0L, TimeUnit.MILLISECONDS,new SynchronousQueue<Runnable>());

        for (int i = 0; i < 5; i++) {
            //method 1
            //pools.submit(new DivTask(100,i));

            //method 2
            //pools.execute(new DivTask(100,i));

            //method 3
            Future re = pools.submit(new DivTask(100,i));
            re.get();


        }
    }
}
