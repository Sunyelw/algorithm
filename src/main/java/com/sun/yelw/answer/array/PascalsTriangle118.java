package com.sun.yelw.answer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     PascalsTriangle118
 * 类描述:     leetcode 118
 * 创建人:     huangyang
 * 创建时间:   2020/5/28 21:29
 */
@SuppressWarnings("all")
public class PascalsTriangle118 {

    public static void main(String[] args){

        List<List<Integer>> list = generate(10);
        for (List<Integer> in : list) {
            System.out.println(in);
        }
    }

    /* 方法1 暴力 */
    // 先初始化 1 2 行
    // 第 i 行 有 i 个数, 第一个与最后一个均为 1
    // 再基于前一行去构造后一行 curr[i] = prev[i - 1] + prev[i]
    private static List<List<Integer>> generate(int numRows) {
        List<Integer[]> arrList = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            Integer[] arr;
            if (i == 1) {
                arr = new Integer[]{1};
                arrList.add(arr);
                continue;
            }
            if (i == 2) {
                arr = new Integer[]{1, 1};
                arrList.add(arr);
                continue;
            }
            Integer[] pre = arrList.get(i - 2);
            arr = new Integer[i];
            arr[0] = arr[i - 1] = 1;
            // 1 -> i - 2
            for (int j = 1; j < i - 1; j++) {
                arr[j] = pre[j - 1] + pre[j];
            }
            arrList.add(arr);
        }

        return arrList.stream().map(Arrays::asList).collect(Collectors.toList());
    }

}
