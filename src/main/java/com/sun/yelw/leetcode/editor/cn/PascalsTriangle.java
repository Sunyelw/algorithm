//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组

package com.sun.yelw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class PascalsTriangle{
    public static void main(String[] args) {

        Solution solution = new PascalsTriangle().new Solution();

        List<List<Integer>> list = solution.generate(10);
        for (List<Integer> in : list) {
            System.out.println(in);
        }
    }
  
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<Integer[]> arrList = new ArrayList <>(numRows);
        for (int i = 1; i <= numRows; i++) {
            Integer[] arr;
            if (i == 1) {
                arr = new Integer[]{1};
                arrList.add(arr);
                continue;
            }
            if (i == 2) {
                arr = new Integer[]{1, 1};
                arrList.add(arr);
                continue;
            }
            Integer[] pre = arrList.get(i - 2);
            arr = new Integer[i];
            arr[0] = arr[i - 1] = 1;
            // 1 -> i - 2
            for (int j = 1; j < i - 1; j++) {
                arr[j] = pre[j - 1] + pre[j];
            }
            arrList.add(arr);
        }

        return arrList.stream().map(Arrays::asList).collect(Collectors.toList());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
