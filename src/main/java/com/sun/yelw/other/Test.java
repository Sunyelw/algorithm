package com.sun.yelw.other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.other
 * 类名称:     Test
 * 类描述:
 * 创建人:     huangyang
 * 创建时间:   2020/5/16 10:26
 */
public class Test {

    private static volatile boolean flag = true;

    public static void main(String[] args) {

        two();
    }

    private static void two() {


        Lock lock = new ReentrantLock();
        Condition two = lock.newCondition();
        new Thread(() -> {
            int n = 0;
            for (;;) {
                if (++n > 10)  break;
                lock.lock();
                System.out.println("lock start");
                try {
                    two.await();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("lock end");
                    lock.unlock();
                }
                System.out.println("n:" + n);
            }

        }, "two").start();

    }

    private static void one() {
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("线程中断标志:"+Thread.currentThread().isInterrupted());
                while (flag){

                }
                System.out.println("标志flag为:" + flag);
                System.out.println("线程中断标志:"+Thread.currentThread().isInterrupted());
                System.out.println("我还在继续执行");
            }
        });

        t.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
        t.interrupt();
    }

}
