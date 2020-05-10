//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 
//
// 提示： 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。 
// Related Topics 数组

package com.sun.yelw.leetcode.editor.cn;

@SuppressWarnings("all")
public class FirstMissingPositive{
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
    }
  
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        // handle 1
        int cnt = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
                break;
            }
        }
        if (cnt == 0) return 1;

        if (nums.length == 1) return 2;

        // pre-handle
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        // + / -
        int index;
        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = - nums[index];
            }
        }

        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
        }
        return i + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
