package com.itgary.pro2.thread3.pro15;

import com.itgary.pro2.thread3.pro14.ThreadA;

/**
 * Created by garychen on 2016/11/9.
 */
public class Sub extends Main {
    @Override
    public void serviceMethod() {
        try {
            System.out.println("sub 1 下一步" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());

            Thread.sleep(3000);

            System.out.println("sub 2 下一步" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());

            super.serviceMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
