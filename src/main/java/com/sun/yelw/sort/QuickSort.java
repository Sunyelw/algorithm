package com.sun.yelw.sort;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.sort
 * 类名称:     QuickSort
 * 类描述:     快排
 * 创建人:     huangyang
 * 创建时间:   2019/8/6 7:31
 */
public class QuickSort {

    /**
     * 快排
     *
     * 时间: O(NlgN)
     *
     * 空间: O(1) (原地排序)
     *
     * 不是稳定排序
     *
     */

    private static void doSort(int[] arr, int p, int r) {

        if (p >= r) {
            return;
        }
        int q = partition(arr, p, r);

        // 这下面一个是 q - 1, 一个是 q + 1
        // q 已经排序过了，如果把 q - 1 换成 q 就会死循环
        doSort(arr, p, q - 1);
        doSort(arr, q + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        // 选定一个pivot
        int pivot = arr[r];
        int x = p - 1;

        int tmp;

        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                x++;
                // swap arr[x] arr[j]
                if (x == j) continue;
                tmp = arr[x];
                arr[x] = arr[j];
                arr[j] = tmp;
            }
        }
        // swap arr[x + 1] arr[r]
        if (r != x + 1) {
            tmp = arr[x + 1];
            arr[x + 1] = arr[r];
            arr[r] = tmp;
        }
        return x + 1;
    }

    public static void main(String[] args){

        int arr[] = new int[]{1, 9, 4, 5, 2, 8, 3, 6};
        doSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
