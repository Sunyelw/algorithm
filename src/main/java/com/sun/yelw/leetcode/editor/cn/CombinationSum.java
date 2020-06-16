//给定一个无重复元素的数组 candidates 和一个目标数 target ，
// 找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法

package com.sun.yelw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum{
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();

        int[] arr = {2, 3, 5};
        System.out.println(solution.combinationSum(arr, 8));
    }
  
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> list = new ArrayList <>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            if (target < 0 || candidates == null || candidates.length == 0) return list;
            recurse(0, candidates, new ArrayList<>(), target);
            return list;
        }

        void recurse(int start, int[] candidates, List<Integer> ls, int target) {

            // 不符合条件,本分支结束
            if (target < 0) return;

            if (target == 0) {
                // 符合条件加入结果集
                list.add(new ArrayList<>(ls));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                Integer num = candidates[i];
                ls.add(num);
                // 可以重复, 这里就可以从当前数字开始
                recurse(i, candidates, ls, target - num);
                ls.remove(ls.size() - 1);
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
