package com.sun.yelw.answer.array;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     FirstMissingPositive41
 * 类描述:     leetcode 41
 * 创建人:     huangyang
 * 创建时间:   2020/5/28 8:17
 */
public class FirstMissingPositive41 {

    public static void main(String[] args){

        int[] arr = {1, 2, 0};
        System.out.println(Arrays.toString(arr));
        System.out.println(firstMissingPositive1(arr));

    }

    // 这个缺失的正整数范围一定在 [1, n+1] (n 为数组长度, n+1 的情况是数组为 1~n )
    // 先把范围外的数替换为 1 -> 要先判断 1 是否存在
    // 思路都是位图 bitmap, 标记好 [1, n] 的数字是否出现过

    /* 方法2 原地数组, 用正负数来处理是否出现 */
    private static int firstMissingPositive1(int[] nums) {
        /* 前面写法都一样 */
        int n = nums.length;
        // 1.先判断是否有 1
        // 2.处理 1
        boolean isOne = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                isOne = true;
            }
            // 这里是 n
            if (nums[i] <= 0 || nums[i] > n) nums[i] = 1;
        }
        if (!isOne) return 1;

        // 3.原地处理(正负)
        // 出现了就标记为负数
        for (int i = 0; i < n; i++) {
            // 要小心负负得正
            int x = nums[Math.abs(nums[i]) - 1];
            if (x > 0) nums[Math.abs(nums[i]) - 1] = -x;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) break;
            res = i + 1;
        }
        return res + 1;
    }

    /* 方法1 借助新字节数组*/
    private static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 1.先判断是否有 1
        boolean isOne = false;
        for (int num : nums) {
            if (num == 1) {
                isOne = true;
                break;
            }
        }
        if (!isOne) return 1;

        // ERROR 2.将 负数/0/大于n+1 的数全部换成 1
        // 2.将 负数/0/大于n 的数全部换成 1
        // 一个长度为 n 的数组, 最多 n 个正整数, 所以这里应该是 n 而不是 n + 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n) nums[i] = 1;
        }

        // 3.位图
        byte[] arr = new byte[n];
        for (int num : nums) {
            arr[num - 1] = 1;
        }

        // 4.遍历结果
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) break;
            res = i + 1;
        }
        return res + 1;
    }
}
