package com.sun.yelw.answer.array;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     RotateArray189
 * 类描述:     leetcode 189
 * 创建人:     huangyang
 * 创建时间:   2020/5/27 21:08
 */
public class RotateArray189 {

    public static void main(String[] args){

        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(nums));
        rotate1(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    /* 方法2 环状数组 */
    // 将数组看成是一个环
    // 循环结束条件就是回到起点, 比如
    // 1 2 3 4 5
    // 1 2 1 4 5 - 3
    // 1 2 1 4 3 - 5
    // 1 5 1 4 3 - 2
    // 1 5 1 2 3 - 4
    // 4 5 1 2 3 - 1 -> 回到起点,循环结束

    // PS: 需要考虑一种情况 length 与 k 存在最大公约数
    // 就是从某个数开始往后跳, 然后后面某个数正好跳回了起点上

    // 举例1  length = 6, k = 2
    // 1 2 3 4 5 6
    // 1 2 1 4 5 6 - 3
    // 1 2 1 4 3 6 - 5
    // 5 2 1 4 3 6 - 1 -> 回到起点
    // 到这里其实只有三个数得到了移动
    // 所以需要额外判断下循环结束时是否移动了所有元素
    private static void rotate1(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == nums.length) break;
            int next, tmp, curr = i, previous = nums[i];
            do {
                next = getNextIndex(curr, k, nums.length - 1);
                tmp = nums[next];
                nums[next] = previous;
                curr = next;
                previous = tmp;
                count++;
            } while (curr != i);
//            } while (curr != i && count != nums.length);
            // 这里不需要加 count != nums.length 判断
            // 因为不管是否遍历全部元素都会跳回起点从而结束循环
            // 只需要在下次循环开始时判断下是否移动全部元素 否则从下一个元素继续循环
        }
    }

    private static int getNextIndex(int currIndex, int k, int max) {
        return currIndex + k <= max ? currIndex + k : currIndex + k - max - 1;
    }


    /* 方法1 旋转数组 */
    // 右移 k 位后, 发现是尾部 k 个元素被移到了前面
    // 三次反转也可以做到
    // 第一次全部反转
    // 第二次反转前 k 个元素
    // 第三次反转后 nums.length - k 个元素
    private static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    // 2 3 4 5 6
    private static void reverse(int[] nums, int s, int e) {
        int sum = s + e, tmp;
        for (int x = s; x <= sum / 2; x++) {
            tmp = nums[x];
            nums[x] = nums[sum - x];
            nums[sum - x] = tmp;
        }
    }
}
