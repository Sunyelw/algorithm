package com.sun.yelw.answer.sort;

import java.util.Arrays;

/**
 * 项目名称:   MyDemo
 * 包:        com.example.demo.sort
 * 类名称:     BubbleSort
 * 类描述:     冒泡排序
 * 创建人:     huangyang
 * 创建时间:   2019/7/29 18:21
 */
public class BubbleSort {

    public static void main(String[] args){

        doSort(new int[]{5, 4, 6, 3, 8, 7, 2, 3, 9, 1});

        System.out.println("---");

        doSort0(new int[]{5, 4, 6, 3, 8, 7, 2, 3, 9, 1});

        System.out.println("+++");

        doSort1(new int[]{5, 4, 6, 3, 8, 7, 2, 3, 9, 1});

    }


    /**
     * 冒泡排序
     *
     * 时间复杂度 最好 O(N) 最坏 O(N^2) 平均 O(N^2)
     * 空间复杂度 O(1) 是原地排序
     * 稳定性:  稳定 (若写成 arr[j] >= arr[j+1] 则不是稳定排序)
     */
    private static void doSort(int[] arr) {

        int tmp;
        boolean flag;
        for (int i = 0; i < arr.length; i++) {
            // 提前结束标志位，如果某次冒泡没有数据交换，表示当前数据已经有序，可以提前结束冒泡排序
            flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
        // 打印结果
        System.out.println(Arrays.toString(arr));
    }

    // 优化, 无序数组的边界处理（借鉴插入排序与选择排序的思路）
    private static void doSort0(int[] arr) {

        int tmp;
        // 上次数据交换位置
        int lastChargeIndex = 0;
        // 无序数组的边界
        int sortBorder = arr.length - 1;
        boolean flag;
        for (int i = 0; i < arr.length; i++) {
            // 提前结束标志位，如果某次冒泡没有数据交换，表示当前数据已经有序，可以提前结束冒泡排序
            flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                    // 记录最后一次更新的记录
                    lastChargeIndex = j;
                }
            }
            if (!flag) break;
            // 更新无序数组的边界
            sortBorder = lastChargeIndex;
        }
        // 打印结果
        System.out.println(Arrays.toString(arr));
    }

    // 优化失败例子
    private static void doSort1(int[] arr) {

        // TODO 为什么只用一个 lastChargeIndex 不行？
        // 因为第一次比较完就改变了 lastChargeIndex 的值，同时改变了内循环的结束条件

        int tmp;
        // 上次数据交换位置
        int lastChargeIndex = arr.length - 1;
        boolean flag;
        for (int i = 0; i < arr.length; i++) {
            // 提前结束标志位，如果某次冒泡没有数据交换，表示当前数据已经有序，可以提前结束冒泡排序
            flag = false;
            for (int j = 0; j < lastChargeIndex; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    lastChargeIndex = j;
                    flag = true;
                }
            }
            if (!flag) break;
        }
        // 打印结果
        System.out.println(Arrays.toString(arr));
    }
}
