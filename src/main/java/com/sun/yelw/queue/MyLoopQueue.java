package com.sun.yelw.queue;

import com.sun.glass.ui.View;
import lombok.Data;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.queue
 * 类名称:     MyLoopQueue
 * 类描述:     循环队列
 * 创建人:     huangyang
 * 创建时间:   2019/8/4 10:07
 */
@Data
public class MyLoopQueue<T> {

    /**
     * 循环队列会浪费一个存储空间
     * 堆满条件为 (tail + 1) % size == head
     *
     * head 和 tail 的自增要注意
     *
     * TODO 并发队列、阻塞队列
     */

    // 队列数组
    private Object[] items;
    // 队头 出队位置
    private int head;
    // 队尾 插入位置
    private int tail;
    // 队当前长度
    private int size;

    private MyLoopQueue(int capacity) {
        items = new Object[capacity];
        size = capacity;
        tail = head = 0;
    }

    // 入队
    private boolean enQueue(T data) {
        // 队满
        if ((tail + 1) % size == head) return false;
        items[tail] = data;
        tail = addTail();
        return true;
    }

    // 出队
    private T deQueue() {

        // 队空
        if (head == tail) return null;

        @SuppressWarnings("unchecked")
        T result = (T) items[head];
        // 出队数据置空，head自增
        items[head] = null;
        head = addHead();
        return result;
    }

    // 队尾自增
    // (tail + 1) % n
    private int addTail() {
        return size - 1 == tail ? 0 : ++tail;
    }

    // 队尾自增
    // (head + 1) % n
    private int addHead() {
        return size - 1 == head ? 0 : ++head;
    }

    @Override
    public String toString(){
        return "MyLoopQueue{" +
                "items=" + Arrays.toString(items) +
                ", head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args){
        MyLoopQueue<String> loop = new MyLoopQueue<>(10);

        System.out.println(loop);

        for (int i = 0; i < 10; i++) {
            System.out.println(loop.enQueue("y" + i));
        }

        System.out.println(loop);

        System.out.println(loop.deQueue());
        System.out.println(loop.deQueue());
        System.out.println(loop.deQueue());

        System.out.println(loop);

        System.out.println(loop.enQueue("x1"));
        System.out.println(loop.enQueue("x2"));
        System.out.println(loop.enQueue("x3"));

        System.out.println(loop);

    }
}
