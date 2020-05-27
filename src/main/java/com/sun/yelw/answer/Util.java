package com.sun.yelw.answer;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer
 * 类名称:     Util
 * 类描述:     util
 * 创建人:     huangyang
 * 创建时间:   2020/5/27 17:11
 */
public class Util {

    public static void swap(int arr[], int one, int two) {
        int z = arr[one];
        arr[one] = arr[two];
        arr[two] = z;
    }
}
