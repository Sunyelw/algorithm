//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
// Related Topics 二分查找 动态规划

package com.sun.yelw.leetcode.editor.cn;

import java.util.Arrays;

public class LongestIncreasingSubsequence{
  public static void main(String[] args) {
       Solution solution = new LongestIncreasingSubsequence().new Solution();
//      int[] nums = {4,10,4,3,8,9};
      int[] nums = {1,3,6,7,9,4,10,5,6};

      System.out.println(Arrays.toString(nums));
      System.out.println(solution.lengthOfLIS(nums));
  }
  
  

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {

        if (null == nums || nums.length == 0) return 0;

        // 状态表示
        // dp[i] 表示前 i 个元素最长上升子序列的长度
        // dp[i] = max( dp[0, j] + 1, dp[i] )
        int[] dp = new int[nums.length + 1];

        // 初始化状态
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        // 状态转移
        // TODO 这里需要一个数组来存储每次的结果，因为后面每次判断都要用到这些结果
        // 前 i 个数的 LIS = max { 前 1 个数的LIS + 1, 前 2 个数的LIS + 1,..., 前 i - 1 个数的LIS + 1 }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j])
                    // dp 要向 nums 借一位，无论是 i 还是 j
                    dp[i + 1] = Math.max(dp[j + 1] + 1, dp[i + 1]);
            }
        }

        // 最终结果
        for (int i = 0; i < dp.length; i++) {
            dp[0] = Math.max(dp[0], dp[i]);
        }
//        System.out.println("dp: " + Arrays.toString(dp));
        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
