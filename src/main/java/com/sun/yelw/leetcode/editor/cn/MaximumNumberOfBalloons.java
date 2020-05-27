//给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。 
//
// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：text = "nlaebolko"
//输出：1
// 
//
// 示例 2： 
//
// 
//
// 输入：text = "loonbalxballpoon"
//输出：2
// 
//
// 示例 3： 
//
// 输入：text = "leetcode"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^4 
// text 全部由小写英文字母组成 
// 
// Related Topics 哈希表 字符串

package com.sun.yelw.leetcode.editor.cn;
public class MaximumNumberOfBalloons{
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfBalloons().new Solution();

        System.out.println(solution.maxNumberOfBalloons("nlaebolko"));
    }

    // 1ms 题解
    // 字符操作确实快
    public int maxNumberOfBalloons(String text) {
        int[] letters = new int[26];
        for(char ch :text.toCharArray()){
            letters[ch - 97] ++;
        }
        letters['l' - 97] /= 2;
        letters['o' - 97] /= 2;
        int min = Integer.MAX_VALUE;
        for(char ch : "balon".toCharArray()){
            if(letters[ch - 97] < min){
                min = letters[ch - 97];
            }
        }
        return min;
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] arr = text.toCharArray();
        // balloon
        // "nlaebolko"
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for (char c : arr) {
            switch (c) {
                case 'a':
                    a++;
                    break;
                case 'b':
                    b++;
                    break;
                case 'l':
                    l++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'n':
                    n++;
                    break;
                default:
                    break;
            }
        }
        l = l / 2;
        o = o / 2;
        return Math.min(Math.min(Math.min(a, b), Math.min(l, o)), n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
