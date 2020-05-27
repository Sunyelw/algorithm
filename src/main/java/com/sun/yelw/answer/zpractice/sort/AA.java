package com.sun.yelw.answer.zpractice.sort;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.zpractice
 * 类名称:     AA
 * 类描述:     aa
 * 创建人:     huangyang
 * 创建时间:   2019/8/17 9:25
 */
public class AA {

    public static void main(String[] args){

//        int[] arr = new int[]{1, 9, 4, 5, 7, 8, 2};
        int[] arr = new int[]{9, 4};
        System.out.println(Arrays.toString(arr));
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        //1544777561698
        //1572569147915
    }


    // bubble

    // quick











    private static void quick(int[] arr, int r, int q) {

        if (r >= q) return;
        int p = partition(arr, r, q);
        quick(arr, r, p - 1);
        quick(arr,p + 1, q);
    }

    private static int partition(int arr[], int r, int q) {
        int pivot = arr[q];
        int x = r - 1;
        for (int i = r; i < q; i++) {
            if (arr[i] < pivot) {
                x++;
                if (x != i) swap(arr, x, i);
            }
        }
        if (x + 1 != q) swap(arr, x + 1, q);
        return x + 1;
    }


    private static void bubble(int[] arr) {
        int count = 0;
        boolean flag;
        int lastIndex = arr.length - 1;
        for (int i = arr.length - 1; i > 0;) {
            flag = false;
            for (int j = 0; j < i; j++) {
                count++;
                if (arr[j] > arr[i]) {
                    swap(arr, j, i);
                    lastIndex = j;
                    flag = true;
                }
            }
            if (!flag) break;
            i = lastIndex;
        }
        System.out.println("count: " + count);
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static int[] arr = new int[10];
    private static int count = 0;

    private static void insert(int val) {

        if (count == arr.length) {
            int sum = 0;
            for (int i : arr) {
                sum += i;
            }
            System.out.println("sum: " + sum);
            count = 0;
        }

        arr[count++] = val;
    }

    private static boolean find(int val) {
        for (int i : arr) {
            if (i == val) return true;
        }
        return false;
    }
}
