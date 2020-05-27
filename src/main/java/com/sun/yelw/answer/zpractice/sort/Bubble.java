package com.sun.yelw.answer.zpractice.sort;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.zpractice
 * 类名称:     Bubble
 * 类描述:     bb s
 * 创建人:     huangyang
 * 创建时间:   2019/8/15 8:01
 */
public class Bubble {

    /**
     * O(N)
     *
     * O(N^2)
     *
     * O(N^2)
     *
     * 原地
     *
     * 稳定
     *
     *
     * @param arr
     * @param n
     */

    private static void doSort(int[] arr, int n) {

        System.out.println(Arrays.toString(arr));

        if (n < 2) return;

        // for swap
        int tmp, count = 0;
        int lastChangeIndex = n - 1, sortBorder = lastChangeIndex;
        boolean isSwap;
        for (int i = 0; i < n; i++) {
            isSwap = false;
            for (int j = 0; j < sortBorder; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    isSwap = true;
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    lastChangeIndex = j;
                }
            }
            sortBorder = lastChangeIndex;
            if (!isSwap) break;
        }
        System.out.println(count);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args){

        int[] arr = {1, 5, 4, 9, 7, 3, 8, 2};
        int[] arr1 = {1, 2, 3, 6, 4, 5, 7, 8, 9};
        doSort(arr, arr.length);

    }

}
