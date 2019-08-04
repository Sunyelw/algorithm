package com.sun.yelw.queue;

import lombok.Data;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.queue
 * 类名称:     MyQueue
 * 类描述:     算法之 队列篇, 基于数组
 * 创建人:     huangyang
 * 创建时间:   2019/8/4 8:30
 */
@Data
public class MyArrayQueue<T> {

    /**
     * 1、数据搬移之后需要将搬移前的数据置空
     * 2、不用每次出队之后都立即做数据搬移，可以入队时判断是否真的队满（tail == size && head == 0）
     *    如果不是真的队满又没有空间了，再统一做数据搬移
     * 3、TODO 这里还可以加一步扩容
     */

    private final static int DEFAULT_CAPACITY = 10;
    private final static int ZERO_FIRST = 0;

    // 队列数组
    private Object[] items;
    // 队头 出队位置
    private int head;
    // 队尾 插入位置
    private int tail;
    // 队当前长度
    private int size;

    public MyArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    private MyArrayQueue(int capacity) {
        if (capacity < DEFAULT_CAPACITY) capacity = DEFAULT_CAPACITY;
        items = new Object[capacity];
        head = ZERO_FIRST;
        tail = ZERO_FIRST;
        size = capacity;
    }

    /**
     * 入队时间复杂度为 O(1)
     */

    // 入队0
    public boolean enQueue0(T data) {
        // 队满
        if (tail == size) return false;

        items[tail++] = data;
        return true;
    }

    /**
     * 最好: O(1)
     * 最坏: O(N)
     * 摊还分析法: size 次 O(1) -->  一次 O(N), 入队时间复杂度为 O(1)
     */

    // 入队1
    private boolean enQueue1(T data) {
        if (tail == size) {
            // 队满
            if (head == ZERO_FIRST) return false;

            // 数据搬移
            System.arraycopy(items, head, items, 0, tail - head);

            // 重置队头队尾
            tail -= head;
            head = ZERO_FIRST;

            // 清空之前的数据
            for (int i = tail; i < size; i++) {
                items[i] = null;
            }
        }

        items[tail++] = data;
        return true;
    }

    // 出队
    private T deQueue() {

        // 队空
        if (head == tail) return null;

        @SuppressWarnings("unchecked")
        T result = (T) items[head];
        items[head++] = null;
        return result;
    }

    @Override
    public String toString(){
        return "MyArrayQueue{" +
                "items=" + Arrays.toString(items) +
                ", head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    // test
    public static void main(String[] args){

        MyArrayQueue<String> queue = new MyArrayQueue <>(10);
        for (int i = 0; i < 10; i++) {
            queue.enQueue1("x" + i);
        }
        System.out.println(queue);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

        System.out.println();

        System.out.println(queue);

        System.out.println(queue.enQueue1("yy"));

        System.out.println(queue);

    }
}
