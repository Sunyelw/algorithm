package com.sun.yelw.linklist;

/**
 * 包:        com.example.demo.algorithm.linklist
 * 类名称:     Other
 * 类描述:     其他算法
 * 创建人:     huangyang
 * 创建时间:   2019/8/3 16:47
 */
public class Other {

    public static void main(String[] args){

        int[] arr = new int[]{1, 24, 66, 76, 2, 89};

        // test
        System.out.println(find(arr, arr.length, 976));
        System.out.println(find0(arr, arr.length, 796));
    }

    // find and find0
    // compare...

    private static int find(int[] arr, int n, int key) {
        int i = 0;

        // 每次循环要比较两次
        while (i < n) {
            if (arr[i] == key) {
                break;
            }
            i++;
        }
        return i < n ? i : -1;
    }

    private static int find0(int[] arr, int n, int key) {

        if (arr[n - 1] == key) return n - 1;

        int tmp = arr[n - 1];
        arr[n - 1] = key;

        // 每次循环只有一次比较
        int i = 0;
        while (arr[i] != key) i++;

        arr[n - 1] = tmp;

        return n - 1 == i ? -1 : i;
    }

}
