package com.sun.yelw.leetcode.string;

import java.util.Arrays;

/**
 * 项目名称:   sunyelw
 * 包:        com.sun.yelw.leetcode
 * 类名称:     StringCode
 * 类描述:     字符串算法
 * 创建人:     huangyang
 * 创建时间:   2019/9/7 12:13
 */
public class Rotate {

    public static void main(String[] args){

        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(nums));
        rotate1(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 189	Rotate Array
     *
     * @param nums 数组
     * @param k 旋转位置
     */

    // 1/handle direct
    private static void rotate1(int[] nums, int k) {

        if ((k = k % nums.length) == 0) return;

        int cnt = 0;
        for (int i = 0; cnt < nums.length; i++) {
            int next;
            int prev = i;
            int tmp = nums[i];
            int xTmp;
            do{
                next = (prev + k) % nums.length;
                xTmp = nums[next];
                nums[next] = tmp;
                prev = next;
                tmp = xTmp;
                cnt++;
            } while (next != i);
        }
    }

    // 0/three reverse
    private static void rotate0(int[] nums, int k) {

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private static void reverse(int[] nums, int start, int end) {

        // 取中
        // >> 小于 +
        int mid = ( (end - start) >> 1 ) + start;
        int tmp, next;
        for (int i = start; i < mid; i++) {
            next = end - i + start;
            tmp = nums[next];
            nums[next] = nums[i];
            nums[i] = tmp;
        }
    }
}
