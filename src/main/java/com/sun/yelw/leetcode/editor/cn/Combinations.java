//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法

package com.sun.yelw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations{
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();

        System.out.println(solution.combine(4, 2));

    }
  
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> list = new ArrayList <>();
    public List<List<Integer>> combine(int n, int k) {

        if (k <= 0 || n < 1) return list;
        process(1, n, k, new ArrayList<>());
        return list;
    }

    private void process(int pos, int n, int k, List<Integer> ls) {

        if (k == 0) {
            list.add(new ArrayList <>(ls));
            return;
        }

        for (int i = pos; i <= n; i++) {
            ls.add(i);
            process(i + 1, n, k - 1, ls);
            ls.remove(ls.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
