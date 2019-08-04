package com.sun.yelw.sort;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.sort
 * 类名称:     SelectSort
 * 类描述:     选择排序
 * 创建人:     huangyang
 * 创建时间:   2019/8/4 16:12
 */
public class SelectSort {


    public static void main(String[] args){

        doSort(new int[]{1, 4, 6, 3, 5, 10, 9});

    }

    /**
     * 时间: 最好/最坏/平均 O(N^2)
     *
     *  因为不管数据有序度多少, 全部程序都会跑一遍;
     *
     *  或者这么说, 不管有序度多少, 代码执行时间一样.
     *
     * 空间: O(1) 原地排序
     * 稳定: 非稳定排序算法
     */
    private static void doSort(int[] arr) {

        int tmp, pos, j;
        for (int i = 0; i < arr.length - 1; i++) {
            tmp = arr[i];
            pos = i;
            j = i + 1;
            while (j < arr.length) {
                if (tmp > arr[j]) {
                    tmp = arr[j];
                    // 记录最小元素的下标
                    pos = j;
                }
                j++;
            }
            if (pos != i) {
                // swap
                j = arr[i];
                arr[i] = tmp;
                arr[pos] = j;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
