//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
//
// 示例 1:
//
// 给定 nums = [1,1,1,2,2,3],
//
//函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
//
//你不需要考虑数组中超出新长度后面的元素。
//
// 示例 2:
//
// 给定 nums = [0,0,1,1,1,1,2,3,3],
//
//函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
//
//你不需要考虑数组中超出新长度后面的元素。
//
//
// 说明:
//
// 为什么返回数值是整数，但输出的答案是数组呢?
//
// 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
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
// Related Topics 数组 双指针

package com.sun.yelw.answer.array;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     RemoveDuplicatesFromSortedArrayIi80
 * 类描述:     leetcode 80
 * 创建人:     huangyang
 * 创建时间:   2020/5/27 20:03
 */
@SuppressWarnings("all")
public class RemoveDuplicatesFromSortedArrayIi80 {

    public static void main(String[] args){
        int[] arr = {1, 2, 2, 2, 4, 5};
        int rel = doRemove(arr);
        System.out.println(rel);
        System.out.println(Arrays.toString(arr));
    }

    // 同排序, 跟 26 差不多
    public static int doRemove(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        if (nums.length < 3) return nums.length;
        int j = 2;
        for (int i = 2; i < nums.length; i++) {
            if (!(nums[i] == nums[j - 1] && nums[i] == nums[j - 2])) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
