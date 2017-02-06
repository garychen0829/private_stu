package com.itgary.pro2.thread0117.test1_ThreadPool.demo8;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.logging.Logger;

/**
 * ForkJoinTask最终要的两个子类，
 *      RecursiveAction;RecursiveTask;
 * RecursiveAction  表示没有返回值的任务
 * RecursiveTask    表示可以携带返回值的任务
 * Created by gary on 2017/2/6.
 */
public class CountTask extends RecursiveTask<Long>{
    private static final int THRESHOLD = 10000;
    //19989995149
    //19989995149
    private long start;
    private long end;

    public CountTask(long start,long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;

        boolean canCompute = (end-start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i < end; i++) {

                System.out.println( i  + " 次;" + "总和: " + sum );
                sum += i;
            }
        }else{
            //分成100个小任务
            long step = (start+end)/100;
            ArrayList<CountTask> subTasks = new ArrayList<CountTask>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                System.out.println(i + ">>> last is = "+lastOne + "    --   end is =" + end);
                if (lastOne > end) {
                    lastOne = end;
                }
                CountTask subTask = new CountTask(pos,lastOne);
                pos += step + 1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for (CountTask t : subTasks){
                sum+=t.join();
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(0,200000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            long res = result.get();
            System.out.println("sum = " + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
