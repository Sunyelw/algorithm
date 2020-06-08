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
        int len = nums.length;

        for(int i = 0; i < nums.length;) {
            if (nums[i] > 0 && nums[i] < len && nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    i++;
                } else {
                    swap(nums, i, nums[i] - 1);
                }
                continue;
            }
            i++;
        }

        int res = len + 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res = i + 1;
                break;
            }
        }

        return res;
    }

    public void swap(int arr[], int one, int two) {
        int z = arr[one];
        arr[one] = arr[two];
        arr[two] = z;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
