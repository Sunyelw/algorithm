package com.sun.yelw.answer.array;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     MaximumSubarray53
 * 类描述:     leetcode 53
 * 创建人:     huangyang
 * 创建时间:   2020/5/28 16:37
 */
@SuppressWarnings("all")
public class MaximumSubarray53 {

    public static void main(String[] args){

        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray1(arr));
    }

    /* 方法2 */
    // O(N)
    private static int maxSubArray1(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }

        return res;
    }

    /* 方法1 暴力破解 */
    // O(N^2)
    private static int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = Integer.MIN_VALUE;
            int curr = 0;
            for (int j = i; j < nums.length; j++) {
                curr += nums[j];
                sum = Math.max(sum, curr);
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
