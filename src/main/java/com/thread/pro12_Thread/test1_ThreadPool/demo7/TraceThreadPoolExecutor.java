package com.thread.pro12_Thread.test1_ThreadPool.demo7;

import com.thread.pro12_Thread.test1_ThreadPool.demo6.DivTask;

import java.util.concurrent.*;

/**
 * 在线程池中寻找堆栈 2
 * Created by garychen on 2017/2/6.
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor{
    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command,clientTrace(),Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task,clientTrace(),Thread.currentThread().getName()));
    }


    private Exception clientTrace(){
        return new Exception("client stack trace");
    }

    private Runnable wrap(final Runnable task, final Exception clientStack,String clientThreadName){
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                }catch (Exception e){
                    clientStack.printStackTrace();
                    throw e;
                }

            }
        };

    }

    public static void main(String[] args) {


//        switch ("b") {
//            case "a":
//                System.out.println("aaa");
//                break;
//            case "b":
//                System.out.println("bbb");
//                break;
//        }

        ThreadPoolExecutor pools = new TraceThreadPoolExecutor(0,Integer.MAX_VALUE,0L, TimeUnit.MILLISECONDS,new SynchronousQueue<Runnable>());
        /**
         * 错误堆栈可以看到是在哪里提交的任务
         */
        for (int i = 0; i < 5; i++) {
            pools.execute(new DivTask(100,i));
        }
    }
}
