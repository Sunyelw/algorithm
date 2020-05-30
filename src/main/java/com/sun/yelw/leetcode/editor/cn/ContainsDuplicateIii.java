//给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
// 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false 
// Related Topics 排序 Ordered Map

package com.sun.yelw.leetcode.editor.cn;

import java.util.TreeSet;

@SuppressWarnings("all")
public class ContainsDuplicateIii{
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();

        int[] arr1 = {-1,2147483647};
        System.out.println(solution.containsNearbyAlmostDuplicate(arr1, 1, 2147483647));
    }
  
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Integer> set = new TreeSet <>();
        Integer ceiling, floor, res;
        for (int i = 0; i < nums.length; i++) {
            // cell  大于等于 x 的最小的
            ceiling = set.ceiling(nums[i]);

            if (null != ceiling && (res = ceiling - nums[i]) <= t){
                // 防止溢出
                if (ceiling >= 0 && nums[i] < 0 && res < 0
                        || ceiling < 0 && nums[i] > 0 && res > 0) {
                } else {
                    return true;
                }
            }

            // floor 小于等于 x 的最大的
            floor = set.floor(nums[i]);
            if (null != floor && (res = nums[i] - floor) <= t) {
                // 防止溢出
                if (nums[i] >= 0 && floor < 0 && res < 0
                        || nums[i] < 0 && floor > 0 && res > 0) {
                } else {
                    return true;
                }
            }

            // 重复元素也不怕
            // 可以当做是用后出现的元素替换了之前的元素, 移除旧元素, 加入新元素, 容量不变
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
