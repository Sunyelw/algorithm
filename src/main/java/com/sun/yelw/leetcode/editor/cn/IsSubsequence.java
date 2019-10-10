//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
//
// （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
//
// 示例 1: 
//s = "abc", t = "ahbgdc" 
//
// 返回 true. 
//
// 示例 2: 
//s = "axc", t = "ahbgdc" 
//
// 返回 false. 
//
// 后续挑战 : 
//
// 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
//
// 在这种情况下，你会怎样改变代码？
//
// 致谢: 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
// Related Topics 贪心算法 二分查找 动态规划

package com.sun.yelw.leetcode.editor.cn;

import java.util.Arrays;

public class IsSubsequence{

    public static void main(String[] args) {
       Solution solution = new IsSubsequence().new Solution();

       String s = "axc";

       String t = "ahbgdc";

//       System.out.println(s.charAt(0));
//       System.out.println(t.substring(0));
//       System.out.println(t.substring(0).indexOf(s.charAt(0)));

       System.out.println("s: " + s);
       System.out.println("t: " + t);
       System.out.println(solution.isSubsequence(s, t));
    }
  
  

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubsequence(String s, String t) {

        if ((null == t || t.length() == 0) && (null == s || s.length() == 0)) return true;
        if (null == t || t.length() == 0) return false;
        if (t.contains(s)) return true;

        // 状态表示
        // dp[i] 表示 s 的前 i 个字符是否为 t 的子序列, 值为顺序往后遍历第一个符合条件的最后一个字符的下标， 为 0 表示不是子序列
        // 存储之前的状态结果
        // 这里需要问自己一个问题: 后续状态是需要用到之前的全部状态还是前几个状态
        // 1 全部状态 则用一个数组存储
        // 2 前N状态 则无需用整个数组, 定义几个局部变量存储就好
        int[] dp = new int[s.length() + 1];

        // 状态初始化

        // 状态迁移
        // 需要符合其出现顺序，依次判断, 是否需要一个指针来表示当前对 t 的寻找到哪了
        for (int i = 0; i < s.length(); i++) {
            int j = t.substring(dp[i]).indexOf(s.charAt(i));
            // 如果没有
            if (j == -1) break;
            dp[i + 1] = dp[i] + j + 1;
        }

        // 状态结果
        // 小于表示不是子序列
        System.out.println("dp: " + Arrays.toString(dp));
        return dp[s.length()] > dp[s.length() - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
