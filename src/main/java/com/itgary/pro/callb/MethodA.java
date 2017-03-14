package com.itgary.pro.callb;

/**
 * Created by garychen on 2017/3/13.
 */
public class MethodA {

    public static void main(String[] args) {
        MethodB b = new MethodB();
        double d = b.getTime(new CallBackInterface() {
            @Override
            public void doSome() {

            }

            @Override
            public void executeMethod() {
                for(int i=0;i<10000;i++){
                    System.out.print("");
                }
            }
        });
        System.out.println("d="+d);
    }

    public void testMethod(){
        for(int i=0;i<100000;i++){

            System.out.print("");
        }

    }
}
