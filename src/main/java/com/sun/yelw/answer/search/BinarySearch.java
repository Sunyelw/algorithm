package com.sun.yelw.answer.search;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.search
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
                high = mid - 1;
            } else {
                high = mid;
            }
        }
        return arr[high] == value ? high : -1;
    }

    private static int doFirstEqual2(int[] arr, int n, int value) {

        int low = 0;
        int high = n -1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] >= value) {
                high = mid - 1;
            }
        }
        return low < n && arr[low] == value ? low : -1;
    }

    //2 查找最后一个等于该值
    private static int doLastEqual2(int[] arr, int n, int value) {

        int low = 0;
        int high = n -1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (arr[mid] <= value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            }
        }
        return high > 0 && arr[high] == value ? high : -1;
    }

    //3 查找第一个大于该值
    private static int doFirstGrater(int[] arr, int n, int value) {

            int low = 0;
            int high = n -1;
            int mid;
            while (low <= high) {
                //
                mid = ((high - low) / 2) + low;
                if (arr[mid] <= value) {
                    low = mid + 1;
                } else if (arr[mid] > value) {
                    high = mid - 1;
                }
            }

        // 比所有数都>=，这种情况的 high 指针一定是指向最后一个元素, low为 n + 1
        if (low > n - 1) return -1;

        // 比所有数都小，low 为 0， high 为 0 - 1 = -1
        // 其他情况直接 high + 1
        return high <= 0 ? 0 : high + 1;
    }

    //4 查找最后一个小于该值
    private static int doLastLess(int[] arr, int n, int value) {

        int low = 0;
        int high = n -1;
        int mid;
        while (low <= high) {
            //
            mid = ((high - low) / 2) + low;
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] >= value) {
                high = mid - 1;
            }
        }

        // 比所有数都<=，这种情况的 low 指针一定是指向第一个元素, high 为 -1
        if (high == -1) return -1;

        // 比所有数都大，low 为 n， high 为 n - 1
        // 其他情况直接 low - 1
        return low >= n ? n - 1 : low - 1;
    }

    public static void main(String[] args){

        int[] arr = {1, 3, 4, 5, 7, 9, 12};
        int[] arr1 = {1, 4, 4, 5, 5, 5, 6, 6, 6, 12};
        int num0 = 0, num1 = 0, num2 = 0, num3, num4;

//        num0 = doLastEqual2(arr, 7, 0);
//        num1 = doLastEqual2(arr, 7, 4);
//        num2 = doLastEqual2(arr, 7, 5);
//        num3 = doLastEqual2(arr, 7, 6);
//        num4 = doLastEqual2(arr, 7, 15);

        num0 = doLastLess(arr1, 10, 0);
        num1 = doLastLess(arr1, 10, 4);
        num2 = doLastLess(arr1, 10, 11);
        num3 = doLastLess(arr1, 10, 12);
        num4 = doLastLess(arr1, 10, 15);

        System.out.println(Arrays.toString(arr1));
        System.out.println("0 -- " + num0);
        System.out.println("4 -- " + num1);
        System.out.println("11 -- " + num2);
        System.out.println("12 -- " + num3);
        System.out.println("15 -- " + num4);
    }

}
