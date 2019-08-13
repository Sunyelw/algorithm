package com.sun.yelw.sort;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.sort
 * 类名称:     CountSort
 * 类描述:     计数排序
 * 创建人:     huangyang
 * 创建时间:   2019/8/12 8:27
 */
public class CountSort {

    /**
     * 1 属于一种特殊的桶排序，数据可以分为 k 种类型（k 为有限值）
     * 2 数组中存 数据 数量, 下标为数据实际值
     * 3 遍历原始数组
     *
     *
     * TODO 倒序遍历原始数组 稳定排序
     */

    // 计数排序
    private static void doSort(int[] arr, int n) {

        if (1 == n) return;

        // 找到最大的那个数
        int len = 0;
        for (int x : arr) {
            len = x > len ? x : len;
        }
        // 构造辅助数组
        int[] arr1 = new int[len];
        for (int y : arr) {
            arr1[y - 1]++;
        }
        // 辅助数组处理
        // TODO (引用错误) 这里处理的是arr1 不是 arr
        for (int i = 1; i < arr1.length; i++) {
            arr1[i] = arr1[i] + arr1[i - 1];
        }
        // 遍历原始数组
        int alen = arr.length;
        int[] arr2 = new int[alen];
        // TODO (逻辑错误) 这里是 -- 不是 ++
        for (int i = alen - 1; i >= 0; i--) {
            arr2[arr1[arr[i] - 1] - 1] = arr[i];
            arr1[arr[i] - 1]--;
        }
        System.arraycopy(arr2, 0, arr, 0, alen);
    }

    public static void main(String[] args){

        int[] arr = {1, 8, 2, 3, 5, 6, 4, 3};
        doSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
