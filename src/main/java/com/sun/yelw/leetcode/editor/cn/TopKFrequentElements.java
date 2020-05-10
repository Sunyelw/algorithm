//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表

package com.sun.yelw.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements{
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // map
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int i = 0;
        for (int key : map.keySet()) {
            nums[i++] = key;
        }

        // // check
//        List<Integer> list = new ArrayList<>();
        // if (i == k) {
        //     for (int a = 0; a < i; a++) list.add(nums[a]);
        //     return list;
        // }

        partition(map, nums, 0, map.size() - 1, k);

//        for (int x = 0; x < k; x++) list.add(nums[x]);
        int[] arr = new int[k];
        System.arraycopy(nums, 0, arr, 0, k);
        return arr;
    }

    void partition(Map <Integer, Integer> map, int[] arr, int x, int y, int k) {
        int pivot = map.get(arr[y]);

        int z = x - 1, i = x;
        for (; i < y; i++) {
            if (map.get(arr[i]) > pivot) {
                z++;
                if (z != i) swap(arr, z, i);
            }
        }
        if (z + 1 != y) swap(arr, z + 1, y);
        // retrieve
        if (z < k && z + 2 <= y) partition(map, arr, z + 2, y, k);
        if (z > k && z >= x) partition(map, arr, x, z, k);
    }

    void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
