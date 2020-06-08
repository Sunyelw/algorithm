//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
//
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//
// 如果 可以变为 1，那么这个数就是快乐数。
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。 
//
// 
//
// 示例： 
//
// 输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学

package com.sun.yelw.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("all")
public class HappyNumber{
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();

        System.out.println(solution.isHappy(1));
    }
  
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet <>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));
        for (;;) {
            if (set.contains(n)) return false;
            if ((n = getRel(n)) == 1) return true;
        }
    }

    private int getRel(int num) {
        int rel = 0, dig, n = num;
        while (n > 0) {
            dig = n % 10;
            rel += dig * dig;
            n /= 10;
        }
        return rel;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
