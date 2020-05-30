package com.sun.yelw.answer.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     ContainsDuplicate217
 * 类描述:     217
 * 创建人:     huangyang
 * 创建时间:   2020/5/29 16:21
 */
@SuppressWarnings("all")
public class ContainsDuplicate217 {

    public static void main(String[] args){

        int[] arr1 = {1,2,3,4};
        int[] arr2 = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(arr1));
        System.out.println(containsDuplicate(arr2));
    }

    /* 排序 + 比较 */
    private static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }


    /* 暴力 */
    private static boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> map = new HashMap <>();
        for (int num : nums) {
            if (map.containsKey(num)) return true;
            map.put(num, 1);
        }
        return false;
    }

}
