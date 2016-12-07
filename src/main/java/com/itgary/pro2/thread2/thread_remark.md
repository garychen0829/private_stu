## ThreadState
note:
+ NEW:              表示刚刚创建的线程,这种线程还没开始执行.等到线程的 start() 方法调用时,才表示线程开始执行.
+ RUNNABLE:         当线程执行时处于 RUNNABLE 状态，表示线程所需的一切资源都已经准备好了。
+ BLOCKED:          如果现在执行的过程中遇到了 synchronized 同步块，就会进入 BLOCKED 阻塞状态，这时线程就会暂停执行，直到获得请求的锁。
+ WAITING:          WAITING 和 TIMED_WAITING 都表示等待状态，它们的区别是WAITING会进入一个无时间限制的等待，
+ TIMED_WAITING:    TIMED_WAITING会进行一个有时间限制的等待。
+ TERMINATED:       当线程执行完毕，则进入 TERMINATED 状态，表示结束。