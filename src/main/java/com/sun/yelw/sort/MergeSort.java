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
        int pn = p;
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

        while (p <= q) {
            tmp[n++] = arr[p++];
        }

        while (p1 <= r) {
            tmp[n++] = arr[p1++];
        }

        System.arraycopy(tmp, 0, arr, pn, n);
    }

    public static void main(String[] args){

        int[] arr = new int[] {4, 1, 2, 7, 8, 6, 5, 9};

        doSort(arr, 0, 3);

        System.out.println(Arrays.toString(arr));

    }

}
