package com.sun.yelw.leetcode.string;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.leetcode.string
 * 类名称:     FindMissing
 * 类描述:     查找未排序数组中的未出现的最小正整数
 * 创建人:     huangyang
 * 创建时间:   2019/9/7 15:24
 */
public class FindMissing {

    public static void main(String[] args){

        int[] arr = {1,2,3,4};
        System.out.println(doFind(arr));
    }

    // 41 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
    private static int doFind(int[] nums) {
        // 1 2 3 4 5 ...

        // handle 1
        int cnt = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
                break;
            }
        }
        if (cnt == 0) return 1;

        if (nums.length == 1) return 2;

        // pre-handle
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        // + / -
        int index;
        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = - nums[index];
            }
        }

        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
        }
        return i + 1;
    }
}
