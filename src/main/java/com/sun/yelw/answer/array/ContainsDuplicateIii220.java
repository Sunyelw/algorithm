package com.sun.yelw.answer.array;

import java.util.TreeSet;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     ContainsDuplicateIii220
 * 类描述:     220
 * 创建人:     huangyang
 * 创建时间:   2020/5/30 16:51
 */
@SuppressWarnings("all")
public class ContainsDuplicateIii220 {

    // <= k 下标差
    // <= t 值差的绝对值

    // 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
    //输出: false

    // 输入: nums = [1,0,1,1], k = 1, t = 2
    //输出: true

    public static void main(String[] args){

        int x = Integer.MAX_VALUE;
        int y = Integer.MIN_VALUE;
        System.out.println(y - y);

    }

    // 关于溢出
    // 整型范围 [-2147483648, 2147483647] 负数比正数大 1
    // 只有 [正 - 负] 跟 [负 - 正] 会溢出
    // PS:  0 - 2147483647

    // TreeSet 维护一个 k 大小的平衡二叉树
    // floor -> x -> ceiling
    // 时间复杂度 O(log(MIN<k, n>))

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Integer> set = new TreeSet <>();
        Integer min, max, res;
        for (int i = 0; i < nums.length; i++) {
            // cell  大于等于 x 的最小的
            min = set.ceiling(nums[i]);
            if (null != min && (res = min - nums[i]) <= t){
                // 防止溢出
                if (min >= 0 && nums[i] < 0 && res < 0
                        || min < 0 && nums[i] > 0 && res > 0) {
                } else {
                    return true;
                }
            }

            // floor 小于等于 x 的最大的
            max = set.floor(nums[i]);
            if (null != max && (res = nums[i] - max) <= t) {
                // 防止溢出
                if (nums[i] >= 0 && max < 0 && res < 0
                        || nums[i] < 0 && max > 0 && res > 0) {
                } else {
                    return true;
                }
            }

            // 重复元素也不怕
            // 可以当做是用后出现的元素替换了之前的元素, 移除旧元素, 加入新元素, 容量不变
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
