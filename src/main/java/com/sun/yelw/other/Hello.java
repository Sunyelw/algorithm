package com.sun.yelw.other;

/*
*
* 题目：设计生产系统

有一家生产奶酪的厂家，每天需要生产100000份奶酪卖给超市.

通过一辆送货车发货，送货车辆每次送100份。

厂家有一个容量为1000份的冷库，用于奶酪保鲜，生产的奶酪需要先存放在冷库。

运输车辆从冷库取货。

厂家有三条生产线，分别是 牛奶供应生产线、发酵剂制作生产线、奶酪生产线。生产每份奶酪需要2份牛奶和1份发酵剂。

请设计生产系统。
 */

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 包:        com.sun.yelw.other
 * 类名称:     MilkLao
 * 类描述:     1
 * 创建人:     huangyang
 * 创建时间:   2020/5/14 15:16
 */
@SuppressWarnings("all")
public class Hello {

    /**
     * 三个生产线程(总共生产10000)
     *
     * 没说牛奶跟发酵剂需要保存,这里不设等待
     *
     * 车取货的线程(每满一百取一次)
     *
     */
    public static void main(String[] args) throws InterruptedException{

        // 运送容量
        final int ALL_SIZE = 2;
        // 当前容量
        final int CURR_CAPACITY = 5;
        // 总生产量
        final int ALL_CAPACITY = 10;

        Lock lock = new ReentrantLock();

        // 取货车
        Condition carCondition = lock.newCondition();
        // 牛奶
        Condition milkCondition = lock.newCondition();
        AtomicInteger milkInt = new AtomicInteger(0);
        // 发酵剂 - 10000
        Condition starterCondition = lock.newCondition();
        AtomicInteger starterInt = new AtomicInteger(0);
        // 奶酪 - 10000
        Condition cheeseCondition = lock.newCondition();
        AtomicInteger cheeseInt = new AtomicInteger(0);

        // 1.生产牛奶
        Thread milkTh = new Thread(() -> {
            int x = 0;
            for (;;) {
                lock.lock();
                System.out.println(x + " milk lock...");
                try {
                    if (x >= ALL_CAPACITY) {
                        break;
                    }
                    // 一次生产两份
                    milkInt.addAndGet(2);
                    System.out.println(x++ + " 生产了两份 milkInt: " + milkInt.get());
                    milkCondition.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(x + " milk unlock...");
                    lock.unlock();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("milk end..."
                    + ", milk:" + milkInt.get() + ", starter:" + starterInt.get() + ", cheese:" + cheeseInt.get());
        }, "milk");
        milkTh.start();

        // 2.生产发酵剂
        Thread starterTh = new Thread(() -> {
            int y = 0;
            for (;;) {
                lock.lock();
                System.out.println(y + " starter lock...");
                try {
                    if (y >= ALL_CAPACITY) {
                        break;
                    }
                    // 一次生产一份
                    starterInt.incrementAndGet();
                    System.out.println(y++ + " 生产了一份 starterInt: " + starterInt.get());

                    starterCondition.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(y + " starter unlock...");
                    lock.unlock();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("starter end..."
                    + ", milk:" + milkInt.get() + ", starter:" + starterInt.get() + ", cheese:" + cheeseInt.get());
        }, "starter");
        starterTh.start();

        // 3.生产奶酪
        Thread cheeseTh = new Thread(() -> {
            int z = 0;
            for (;;) {
                lock.lock();
                System.out.println(z + " cheese lock...");
                try {
                    if (z >= ALL_CAPACITY) {
                        break;
                    }
                    if (starterInt.get() < 1) starterCondition.await();
                    if (milkInt.get() < 2) milkCondition.await();

                    /* 1奶酪 = 2牛奶 + 1发酵剂 */
                    // 2牛奶
                    milkInt.compareAndSet(milkInt.get(), milkInt.get() - 2);
                    // 1发酵剂
                    starterInt.decrementAndGet();
                    // 1奶酪
                    int num = cheeseInt.incrementAndGet();
                    System.out.println(z++ + " 生产了一份 cheeseInt: " + cheeseInt.get());
                    // 唤醒运货车
                    carCondition.signal();
                    // 超过了 1000 份奶酪
                    if (CURR_CAPACITY <= num) {
                        // 停止生产
                        cheeseCondition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(z + " cheese unlock...");
                    lock.unlock();
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("cheese end..."
                    + ", milk:" + milkInt.get() + ", starter:" + starterInt.get() + ", cheese:" + cheeseInt.get());
        }, "cheese");
        cheeseTh.start();

        // 4.car
        Thread carTh = new Thread(() -> {
            int p = 0;
            for (;;) {
                lock.lock();
                System.out.println(p + " car lock...");
                try {
                    if (p >= ALL_CAPACITY / ALL_SIZE) {
                        break;
                    }
                    // 1.没满运货车数量
                    if (cheeseInt.get() < ALL_SIZE) {
                        // 1.唤醒生产奶酪
                        cheeseCondition.signal();
                        // 2.运货车等待
                        carCondition.await();
                        continue;
                    }
                    // 可以运送
                    if (cheeseInt.compareAndSet(cheeseInt.get(), cheeseInt.get() - ALL_SIZE)) {
                        System.out.println(p++ + " 运送 cheeseInt: " + cheeseInt.get());
                        // 可以继续生产奶酪
                        cheeseCondition.signal();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(p + " car unlock...");
                    lock.unlock();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("car end..."
                    + ", milk:" + milkInt.get() + ", starter:" + starterInt.get() + ", cheese:" + cheeseInt.get() + ", p:" + p);
        }, "car");
        carTh.start();
    }
}
