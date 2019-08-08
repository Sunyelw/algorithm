package com.sun.yelw.search;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.search
 * 类名称:     BinarySearch
 * 类描述:     二分查找
 * 创建人:     huangyang
 * 创建时间:   2019/8/8 7:45
 */
public class BinarySearch {


    // 二分查找
    private static int doEqual(int[] arr, int n, int value) {

        if (n == 0) return -1;
        if (n == 1) return arr[n] == value ? n : -1;

        // 双指针
        int low = 0;
        int high = n -1;
        int mid = -1;
        while (low <= high) {
            // 防止 low + high 溢出
//            mid = (high + low) >> 1;
            mid = low + ((high - low) >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                break;
            }
        }
        return low <= high ? mid : -1;
    }

    /**
     * 二分查找的几个变种，基于有序数组中存在重复元素的情况
     *
     * 默认数组从小到大排序，从左到右遍历
     */

    //1 查找第一个等于该值
    private static int doFirstEqual(int[] arr, int n, int value) {

        int low = 0;
        int high = n -1;
        int mid = -1;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == 0 || arr[mid - 1] != value) break;
                high = mid - 1;
            }
        }
        return low <= high ? mid : -1;
    }

    private static int doFirstEqual1(int[] arr, int n, int value) {

        int low = 0;
        int high = n -1;
        int mid;
        while (low < high) {
            mid = low + ((high - low) >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[high] == value ? high : -1;
    }

    //2 查找最后一个等于该值

    //3 查找第一个大与该值

    //4 查找最后一个小于该值

    public static void main(String[] args){

        int[] arr = {1, 4, 4, 4, 7, 9, 12};
        int[] arr1 = {1, 4, 4, 5, 5, 5, 6, 6, 6, 12};
        int num, num1, num2, num3;

        num = doEqual(arr, 7, 4);

        num1 = doFirstEqual1(arr1, 10, 4);
        num2 = doFirstEqual1(arr1, 10, 5);
        num3 = doFirstEqual1(arr1, 10, 6);

        System.out.println(Arrays.toString(arr1));
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }

}
