package com.sun.yelw.answer.zpractice.sort;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.zpractice
 * 类名称:     Select
 * 类描述:     选择排序
 * 创建人:     huangyang
 * 创建时间:   2019/8/22 8:29
 */
public class Select {

    /**
     *  O(N^2)
     *
     *  O(N^2)
     *
     *  O(N^2)
     *
     *  原地
     *
     *  不稳定
     *
     *
     * @param arr
     * @param len
     */

    private static void doSort(int[] arr, int len) {

        if (len < 2) return;

        for (int i = 0; i < len; i++) {
            int j = i;
            int minPos = j;
            int tmp = arr[j];
            // find the smallest data
            while (j < len - 1) {
                if (arr[j + 1] < tmp) {
                    minPos = j + 1;
                    tmp = arr[j + 1];
                }
                j++;
            }
            // swap arr[maxPos] arr[i]
            if (minPos != i) {
                int xtmp = arr[i];
                arr[i] = arr[minPos];
                arr[minPos] = xtmp;
            }
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args){

        int[] arr = {2, 5, 4, 8, 3, 9, 1};
        doSort(arr, arr.length);

    }
}
