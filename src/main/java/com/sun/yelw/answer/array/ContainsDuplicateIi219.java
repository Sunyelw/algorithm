package com.sun.yelw.answer.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     ContainsDuplicateIi219
 * 类描述:     219
 * 创建人:     huangyang
 * 创建时间:   2020/5/29 16:33
 *
 */
 @SuppressWarnings("all")
public class ContainsDuplicateIi219 {

    public static void main(String[] args){

        int[] nums = {1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate3(nums, 2));

    }


    /* 滑动窗口3 */
    // 合并
    private static boolean containsNearbyDuplicate3(int[] nums, int k) {

        // 0.判断入口
        k++;
        k = k > nums.length ? nums.length : k;
        Set<Integer> set = new HashSet <>();

        // 1.先判断初始窗口是否存在
        // 2.初始窗口没有相等的, 移动窗口
        for (int i = 0; i < nums.length; i++) {
            // 需要先移除再判断
            // 1.移除
            if (i >= k) {
                set.remove(nums[i - k]);
            }
            // 2.判断
            if (set.contains(nums[i])) return true;
            // 3.加入
            set.add(nums[i]);
        }

        return false;
    }

    /* 滑动窗口2 */
    // 使用 HashSet
    // 窗口大小为 k + 1
    // 9ms
    private static boolean containsNearbyDuplicate2(int[] nums, int k) {

        // 0.判断入口
        k++;
        k = k > nums.length ? nums.length : k;
        Set<Integer> set = new HashSet <>();

        // 1.先判断初始窗口是否存在
        for (int i = 0; i < k; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        // 2.初始窗口没有相等的, 移动窗口
        for (int i = k; i < nums.length; i++) {
            set.remove(nums[i - k]);
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }



    /* 滑动窗口1 */
    // 1472 ms
    private static boolean containsNearbyDuplicate1(int[] nums, int k) {

        // 0.判断入口
        k = k > nums.length ? nums.length : k;

        // 1.先判断初始窗口是否存在
        for (int i = 0; i < k - 1; i++) {
            for (int j = i + 1; j < k; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }

        // 2.初始窗口没有相等的, 移动窗口
        for (int i = k; i < nums.length; i++) {
            for (int j = i - k; j < i; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }

        return false;
    }


    /* 暴力 */
    // 10ms
    private static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap <>();
        int x = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                x = Math.min(x, i - map.get(nums[i]));
                if (x <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
