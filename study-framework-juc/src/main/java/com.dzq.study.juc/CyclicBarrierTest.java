package com.dzq.study.juc;
/**
 * 描述:
 * 包名:com.dzq.study.juc
 * 版本信息: 版本1.0
 * 日期:2021/9/12
 * Copyright 三合力通
 */


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @describe：
 * @author: dengzq/三合力通
 * @version:v1.0 2021/9/12 21:18
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("**************"));

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    System.out.println("线程i：" + finalI);
                    try {
                        Thread.sleep(1000);
                        barrier.await();
                        System.out.println(finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
