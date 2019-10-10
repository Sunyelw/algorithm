//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，
// 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统
// ，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
// Related Topics 动态规划

package com.sun.yelw.leetcode.editor.cn;
public class HouseRobberIi{
  public static void main(String[] args) {
       Solution solution = new HouseRobberIi().new Solution();

       int nums[] = {2,3,2};

      System.out.println(solution.rob(nums));

  }
  
  

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {

        // 由于是一个环就要多考虑一种情况
        // 按是否偷取第一间房间分两种情况处理（以决定最后一间房是否要算在偷取范围内）, 然后再取最大值

        /* one solution start */

        if (nums.length == 0) return 0;

        // init
        int[] dp = new int[nums.length + 1];

        for (int j = 0; j < 2; j++) {
            dp[1] = j == 1 ? nums[0] : 0;
            // transfer
            // dp[i] = max{ dp[i - 1], dp[i - 2] - nums[i]};
            for (int i = 2; i <= nums.length; i++) {
                if (i == nums.length && j == 1) {
                    dp[i] = Math.max(dp[i - 1], dp[i]);
                } else {
                    dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
                }
            }
        }
        // result
        return dp[nums.length];

        /* one solution end */
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
