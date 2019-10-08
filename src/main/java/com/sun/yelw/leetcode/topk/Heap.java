package com.sun.yelw.leetcode.topk;

import lombok.Data;

import java.util.Map;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.leetcode.topk
 * 类名称:     Heap
 * 类描述:     自定义堆实现
 * 创建人:     huangyang
 * 创建时间:   2019/10/5 8:42
 */
@Data
public class Heap {

    // 当前存储元素数量, 即下标
    private int count;
    // 最大容量
    private int capacity;
    // 元素数组, 堆其实是一个完全二叉树, 使用数组存储最省
    private int[] arr;
    // 需要比较的map, 其他类似比较
    private Map<Integer, Integer> map;

    // 构造函数
    Heap(int cnt, Map<Integer, Integer> map) {
        this.arr = new int[cnt + 1];
        this.count = 0;
        this.capacity = cnt;
        this.map = map;
    }

    // 由上而下
    private void upHeapIfy(int x, int y) {
        int minPos, sL, sR;
        while(true) {
            minPos = x;
            if ((sL = x << 1) < y && map.get(arr[sL]) < map.get(arr[x])) minPos = sL;
            if ((sR = (x << 1) + 1) < y && map.get(arr[sR]) < map.get(arr[minPos])) minPos = sR;
            if (minPos == x) break;
            swap (x, minPos);
            x = minPos;
        }
    }

    // 由下而上
    private void downHeapIfy(int x, int y) {
        int n;
        while ((n = y / 2) >= x) {
            if (map.get(arr[n]) > map.get(arr[y])) {
                swap(n, y);
                y = n;
            } else {
                break;
            }
        }
    }

    // 插入,维持堆最大容量, 进行插入或删除堆顶元素
    // 插入在最后所以是由下而上的堆化
    void insert (int newInt) {
        if ( count == capacity ) {
            if (map.get(arr[1]) < map.get(newInt)) {
                deleteTop();
            } else {
                return;
            }
        }
        arr[++count] = newInt;
        downHeapIfy(1, count);
    }

    // 删除堆顶元素,出堆
    // 将最后一个元素顶上, 进行一次由上而下的堆化
    private void deleteTop() {
        arr[1] = arr[count];
        arr[count] = 0;
        upHeapIfy(1, count);
        count--;
    }

    // 交换
    private void swap(int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
