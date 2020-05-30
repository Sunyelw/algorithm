package com.sun.yelw.answer.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     MajorityElementIi229
 * 类描述:     lc 229
 * 创建人:     huangyang
 * 创建时间:   2020/5/29 14:44
 */
@SuppressWarnings("all")
public class MajorityElementIi229 {

    public static void main(String[] args){

        int[] arr = {1,1,1,3,3,2,2,2};
        System.out.println(majorityElement1(arr));
    }

    /* 摩尔投票 */
    // 找超过 n/3 的元素, 这种元素一定不超过两个
    // 同理, 超过 n/m 的元素, 这种元素一定不超过 m-1 个
    private static List<Integer> majorityElement1(int[] nums) {
        List<Integer> list = new ArrayList <>();

        // 第一个候选
        int count1 = 0;
        int cand1 = nums[0];
        // 第二个候选
        int count2 = 0;
        int cand2 = nums[0];

        for (int n : nums) {
            // 1.跟候选人相同的情况
            if (n == cand1 || n == cand2) {
                if (n == cand1) {
                    count1++;
                } else {
                    count2++;
                }
                continue;
            }
            // 2.跟候选人都不一样
            if (count1 <= 0) {
                cand1 = n;
                count1 = 1;
                continue;
            } else if (count2 <= 0) {
                cand2 = n;
                count2 = 1;
                continue;
            }
            count1--;
            count2--;
        }

        if (count1 > 0) list.add(cand1);
        if (count2 > 0) list.add(cand2);
        return list;
    }

    /* 暴力 */
    private static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList <>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int x = 0, max = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                list.add(entry.getKey());
            }
        }

        return list;
    }
}
