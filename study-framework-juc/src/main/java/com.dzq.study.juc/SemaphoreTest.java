package com.dzq.study.juc;
/**
 * 描述:
 * 包名:com.dzq.study.juc
 * 版本信息: 版本1.0
 * 日期:2021/9/12
 * Copyright 三合力通
 */


import java.util.concurrent.Semaphore;

/**
 * @describe：
 * @author: dengzq/三合力通
 * @version:v1.0 2021/9/12 17:40
 */
public class SemaphoreTest {

    public static volatile int num = 10;

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(10);
        for (int i = 0; i < 50; i++) {
            new Thread(() -> testSemaphore(semaphore)).start();
        }
        Thread.sleep(10000);
        System.out.println(num);
    }

    private static void testSemaphore(Semaphore semaphore) {
        boolean acquire = semaphore.tryAcquire();
        if (acquire) {
            try {
                num--;
                System.out.println(semaphore.availablePermits());
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }else {
            System.out.println("acquire failure");
        }
    }
}
