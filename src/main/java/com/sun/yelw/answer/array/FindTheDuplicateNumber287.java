//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
//
// 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
//
// 示例 1:
//
// 输入: [1,3,4,2,2]
//输出: 2
//
//
// 示例 2:
//
// 输入: [3,1,3,4,2]
//输出: 3
//
//
// 说明：
//
//
// 不能更改原数组（假设数组是只读的）。
// 只能使用额外的 O(1) 的空间。
// 时间复杂度小于 O(n2) 。
// 数组中只有一个重复的数字，但它可能不止重复出现一次。
//
// Related Topics 数组 双指针 二分查找

package com.sun.yelw.answer.array;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     FindTheDuplicateNumber287
 * 类描述:     287
 * 创建人:     huangyang
 * 创建时间:   2020/6/1 14:08
 */
@SuppressWarnings("all")
public class FindTheDuplicateNumber287 {

    public static void main(String[] args){

        int[] arr = {4,3,1,4,2};
        System.out.println(findDuplicate(arr));

    }

    /* 方法1 快慢指针 */
    // 数组包含 n+1 个数字, 大小都在 1~n 之间
    // 用数组的值指向数组下标,由此就是一个链表
    // 由于有一个重复的数,所以这条链表中一定有环
    private static int findDuplicate(int[] nums) {

        // 1.先找到环相遇点
        int slow = 0, fast = 0;
        for (;;) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        // 2.再找到环入口
        int find = 0;
        for (;;) {
            find = nums[find];
            slow = nums[slow];
            if (slow == find) return find;
        }
    }

    /* error */
    private static int findDuplicate0(int[] nums) {

        int len = nums.length;
        int slow = -1, fast = -1;
        for (;;) {
            if (nums[(slow += 1) % len] == nums[(fast += 2) % len]) {
                break;
            }
        }
        return nums[slow % len];
    }
}
