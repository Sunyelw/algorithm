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
 * 创建时间:   2020/5/13 20:16
 */
public class MilkLao {

    /**
     * 三个生产线程(总共生产10000)
     *
     * 没说牛奶跟发酵剂需要保存,这里不设等待
     *
     * 车取货的线程(每满一百取一次)
     *
     */
    public static void main(String[] args){

        // 运送容量
        final int ALL_SIZE = 1000;
        // 总生产量
        final int ALL_CAPACITY = 10000;

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
        new Thread(() -> {
            int x = 0;
            for (;;) {
                try {
                    if (x >= ALL_CAPACITY) {
                        break;
                    }
                    // 一次生产两份
                    milkInt.addAndGet(2);
                    x++;
                    milkCondition.notify();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("milk end...");
        }).start();

        // 2.生产发酵剂
        new Thread(() -> {
            int y = 0;
            for (;;) {
                try {
                    if (y >= ALL_CAPACITY) {
                        break;
                    }
                    // 一次生产一份
                    starterInt.addAndGet(1);
                    y++;
                    starterCondition.notify();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("starter end...");
        }).start();

        // 3.生产奶酪
        new Thread(() -> {
            int z = 0;
            for (;;) {
                try {
                    if (z >= ALL_CAPACITY) {
                        break;
                    }
                    cheeseCondition.wait();
                    starterCondition.wait();
                    milkCondition.wait();

                    /* 1奶酪 = 2牛奶 + 1发酵剂 */
                    // 2牛奶
                    milkInt.compareAndSet(milkInt.get(), milkInt.get() - 2);
                    // 1发酵剂
                    starterInt.compareAndSet(starterInt.get(), starterInt.get() - 1);

                    z++;
                    // 1奶酪
                    if (ALL_SIZE <= cheeseInt.getAndIncrement()) {
                        // 超过了 1000 份奶酪停止时生产
                        carCondition.wait();
                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("cheese end...");
        }).start();

        // 4.car
        new Thread(() -> {
            int p = 0;
            for (;;) {
                try {
                    if (p >= ALL_CAPACITY / ALL_SIZE) {
                        break;
                    }
                    if (cheeseInt.get() < ALL_SIZE) {
                        cheeseCondition.notify();
                        continue;
                    }
                    // 一次运送
                    cheeseInt.compareAndSet(cheeseInt.get(), cheeseInt.get() - 100);
                    p++;
                    // 可以继续生产奶酪
                    carCondition.notify();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("car end...");
        }).start();
    }
}
