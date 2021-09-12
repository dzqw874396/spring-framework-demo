package com.dzq.study.juc;
/**
 * 描述:
 * 包名:com.dzq.study.juc
 * 版本信息: 版本1.0
 * 日期:2021/9/12
 * Copyright 三合力通
 */


import java.util.concurrent.CountDownLatch;

/**
 * @describe：CountDownLatch调用await方法会循环等待内部AQS中的state字段为0时返回结果（为0则返回1，不为0则返回-1） 允许一个或多个线程一直等待，直到其他线程执行完后再执行。
 * @应用场景: 某一线程在开始运行前等待n个线程执行完毕。计数器变为0，多个线程同时被唤醒。
 * @author: dengzq/三合力通
 * @version:v1.0 2021/9/12 19:50
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        Object lock = new Object();
        for (int i = 0; i < 10; i++) {
            countDownLatchTest(latch, lock, i);
        }

        new Thread(()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 start");
        }).start();

        new Thread(()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 start");
        }).start();

    }

    private static void countDownLatchTest(CountDownLatch latch, Object lock, int i) {
        int finalI = i;
        new Thread(()->{
            synchronized (lock){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程i:"+ finalI);
                latch.countDown();
            }
        }).start();
    }
}
