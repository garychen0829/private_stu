package com.itgary.pro2.thread3.pro11;

/**
 * Created by garychen on 2016/11/9.
 */
public class PublicVar {

    public String username = "A";
    public String password = "AA";

    synchronized public void setValue(String username, String password){
        try {

            this.username = username;
            Thread.sleep(2000);

            this.password = password;

            System.out.println("setValue method thread name=" + Thread.currentThread().getName() + " username="+ username + " password=" + password);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void getValue() {
        System.out.println("getValue method thread name=" + Thread.currentThread().getName() + " username="+ username + " password=" + password);
    }

}
