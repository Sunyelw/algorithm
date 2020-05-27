//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
//
//
//
// 示例 1:
//
// 给定数组 nums = [1,1,2],
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
//
//你不需要考虑数组中超出新长度后面的元素。
//
// 示例 2:
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
//
//
//
//
// 说明:
//
// 为什么返回数值是整数，但输出的答案是数组呢?
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
//
// 你可以想象内部操作如下:
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
//
// Related Topics 数组 双指针

package com.sun.yelw.answer.array;

import com.sun.yelw.answer.Util;

import java.util.Arrays;

/**
 * 包:        com.sun.yelw.answer.array
 * 类名称:     RemoveDuplicatesFromSortedArray26
 * 类描述:     leetcode 26
 * 创建人:     huangyang
 * 创建时间:   2020/5/27 17:17
 */
public class RemoveDuplicatesFromSortedArray26 {

    public static void main(String[] args){

        int[] arr = {1, 1, 2, 2, 4, 6, 7, 7, 8, 10};
        int rel = doRemove1(arr);
        System.out.println(rel);
        System.out.println(Arrays.toString(arr));
    }

    // 由于是排序数组,所以这里可以更简单点
    private static int doRemove1(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    // 双指针
    private static int doRemove(int[] arr) {
        int x = -1;
        for (int i = 0; i < arr.length; i++) {
            if (!isContain(arr, i, arr[i])) {
                x++;
                if (x != i) {
                    Util.swap(arr, i, x);
                }
            }
        }
        return x + 1;
    }

    private static boolean isContain(int[] arr, int offset, int val) {
        for (int i = 0; i < offset; i++) {
            if (arr[i] == val) return true;
        }
        return false;
    }

}
