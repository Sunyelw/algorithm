//给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 
//
// 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: [3] 
//
// 示例 2: 
//
// 输入: [1,1,1,3,3,2,2,2]
//输出: [1,2] 
// Related Topics 数组

package com.sun.yelw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class MajorityElementIi{
    public static void main(String[] args) {
        Solution solution = new MajorityElementIi().new Solution();

        int[] arr = {3, 3, 3, 3};
        System.out.println(solution.majorityElement(arr));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
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
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
