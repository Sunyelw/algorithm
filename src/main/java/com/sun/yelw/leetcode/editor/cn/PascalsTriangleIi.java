//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组

package com.sun.yelw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class PascalsTriangleIi{
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
//        System.out.println(solution.getRow(1));
//        System.out.println(solution.getRow(2));
//        System.out.println(solution.getRow(3));
//        System.out.println(solution.getRow(4));
        System.out.println(solution.getRow(3));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList <>();
        if (rowIndex == 0) return list;
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
            list.add(1);
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
