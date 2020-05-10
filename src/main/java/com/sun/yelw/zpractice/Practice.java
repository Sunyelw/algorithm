package com.sun.yelw.zpractice;

import java.util.Arrays;

public class Practice {

    public static void main(String[] args){

        int[] arr = new int[]{1, 9, 4, 5, 7, 8, 2};
        System.out.println(Arrays.toString(arr));
        bubble(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(foo(1));
        System.out.println(foo(2));
        System.out.println(foo(3));
        System.out.println(foo(7));
    }

    private static void bubble(int[] arr) {

        // 运行次数
        int count = 0;
        // 是否有交换, 提前结束标识
        boolean flag;
        // 有序无序数组分界
        int lastIndex = arr.length - 1, index = lastIndex;
        for (int i = lastIndex; i > 0; i--) {
            flag = false;
            for (int j = 0; j < lastIndex; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                    index = j;
                }
            }
            lastIndex = index;
            if (!flag) break;
        }
        System.out.println("count: " + count);
    }

    // 七级台阶
    // 动态规则 DP
    private static int foo(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return foo(n - 1) + foo(n - 2);

    }

    // 交换
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
