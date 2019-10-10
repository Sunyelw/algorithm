//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
// 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2: 
//
// 输入: [2,7,9,3,1]
//输出: 12
//解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
// Related Topics 动态规划

package com.sun.yelw.leetcode.editor.cn;

public class HouseRobber{
  public static void main(String[] args) {

      Solution solution = new HouseRobber().new Solution();
      // dp三板斧
      // 状态转移

      // dp[0] = 0
      // dp[1] = arr[1]
      // dp[2] = max (dp[1], dp[1] - arr[1] + arr[2])
      // dp[i] 表示前 i 间房最大抢劫金额
      // dp[i] = max { dp[i - 1], dp[i - 2] + arr[i] }

      // 状态

      int[] nums = {1};

      System.out.println(solution.rob(nums));
  }
  
  

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {

        /* two solution start */

        int a = 0, b = 0;
        int tmp;
        for (int i : nums) {
            tmp = b;
            b = Math.max(b, a + i);
            a = tmp;
        }
        return b;

        /* two solution end */

//        /* one solution start */
//
//        if (nums.length == 0) return 0;
//
//        // init
//        int[] dp = new int[nums.length + 1];
//        dp[0] = 0;
//        dp[1] = nums[0];
//
//        // transfer
//        // dp[i] = max{ dp[i - 1], dp[i - 2] - nums[i]};
//        for (int i = 2; i <= nums.length; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
//        }
//
//        // result
//        return dp[nums.length];
//
//        /* one solution end */
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
