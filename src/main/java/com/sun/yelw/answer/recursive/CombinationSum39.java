package com.sun.yelw.answer.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.recursive
 * 类名称:     CombinationSum39
 * 类描述:     39
 * 创建人:     huangyang
 * 创建时间:   2020/6/10 21:16
 * @see Combinations77
 */
public class CombinationSum39 {

    private static List<List<Integer>> lists = new ArrayList <>();

    public static void main(String[] args){

        // [2,2,2,2]
        // [2,3,3]
        // [3,5]
        int[] arr = {2, 3, 5};
        System.out.println(combinationSum(arr, 8));
    }

    /* 方法2 success */

    private static List<List<Integer>> combinationSum1(int[] candidates, int target) {

        if (target < 0 || candidates == null || candidates.length == 0) return lists;
        recurse1(0, candidates, new ArrayList<>(), target);
        return lists;
    }

    private static void recurse1(int start, int[] candidates, List<Integer> ls, int target) {

        // 不符合条件,本分支结束
        if (target < 0) return;

        if (target == 0) {
            // 符合条件加入结果集
            lists.add(new ArrayList<>(ls));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            Integer num = candidates[i];
            ls.add(num);
            // 可以重复, 这里就可以从当前数字开始
            recurse1(i, candidates, ls, target - num);
            ls.remove(ls.size() - 1);
        }
    }


    /* 方法1 error */

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (null == candidates || candidates.length < 1 || target < 0) return lists;

        // 1.先设置递归函数
        recurse(candidates, new ArrayList <>(), target);
        return lists;
    }
    private static void recurse(int[] candidates, List<Integer> list, int target) {
        // 2.递归结束条件
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(list);
            return;
        }

        // 3.递归体
        for (int candidate : candidates) {
            list.add(candidate);
            if (target - candidate == 0) {
                lists.add(list);
                return;
            }
            if (target - candidate < 0) {
                continue;
            }
            recurse(candidates, list, target - candidate);
            list.remove(candidate);
        }
    }
}
