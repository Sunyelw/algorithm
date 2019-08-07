package com.sun.yelw.sort;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.sort
 * 类名称:     MergeSort
 * 类描述:     归并排序
 * 创建人:     huangyang
 * 创建时间:   2019/8/6 20:15
 */
public class MergeSort {

    private static void doSort(int[] arr, int p, int r) {

        if (p < r) {
            int q = (p + r) >> 1;
            // 对子数组排序
            doSort(arr, p, q);
            doSort(arr, q + 1, r);
            // 合并两个子数组
            merge(arr, p, q, r);
        }
    }

    // p q r 都是下标
    private static void merge(int[] arr, int p, int q, int r) {

        int[] tmp = new int[arr.length];
        // TODO 记录本次循环数组开始位置, 用于后面替换数组
        int pn = p;
        // 第二个子数组开始下标
        int p1 = q + 1;

        // p -> q, q + 1 > r
        int n = 0;
        while (p <= q && p1 <= r) {
            if (arr[p] <= arr[p1]) {
                tmp[n] = arr[p];
                p++;
            } else {
                tmp[n] = arr[p1];
                p1++;
            }
            n++;
        }

        // 将多出部分入数组
        while (p <= q) {
            tmp[n++] = arr[p++];
        }
        while (p1 <= r) {
            tmp[n++] = arr[p1++];
        }

        // TODO 数组替换
        // tmp 从 0 开始填充数据
        // arr 从 pn 开始的比较
        // 总计n个数, 下标 + 1 为实际数量
        System.arraycopy(tmp, 0, arr, pn, n);
    }

    public static void main(String[] args){

        int[] arr = new int[] {4, 1, 2, 7, 8, 6, 5, 9};

        doSort(arr, 0, 3);

        System.out.println(Arrays.toString(arr));

    }

}
