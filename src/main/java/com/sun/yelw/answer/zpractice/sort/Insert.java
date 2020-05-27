package com.sun.yelw.answer.zpractice.sort;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.zpractice
 * 类名称:     Insert
 * 类描述:     插入排序
 * 创建人:     huangyang
 * 创建时间:   2019/8/22 8:16
 */
public class Insert {


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
     * @param arr
     * @param len
     */

    private static void doSort(int[] arr, int len) {

        if (len < 2) return;

        int tmp, j;
        for (int i = 1; i < len; i++) {
            tmp = arr[i];
            j = i - 1;
            while (j > -1 && arr[j] > tmp) {
                // swap arr[j] arr[j + 1]
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args){

        int[] arr = {2, 5, 4, 8, 3, 9, 1};
        doSort(arr, arr.length);
    }

}
