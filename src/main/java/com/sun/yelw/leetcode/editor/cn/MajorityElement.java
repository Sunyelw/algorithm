//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法

package com.sun.yelw.leetcode.editor.cn;

@SuppressWarnings("all")
public class MajorityElement{
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();

        for (int i = 0; i < 10; i++) {
            System.out.println(i % 3 + i / 3);
        }

    }
  
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {

        int count = 0;
        int candidate = 0;
        for (int n : nums) {
            if (count == 0) candidate = n;
            if (n == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
