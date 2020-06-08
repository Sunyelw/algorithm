//给定一个字符串S，通过将字符串S中的每个字母转变大小写，
//
// 我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
//
// 
//示例:
//输入: S = "a1b2"
//输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入: S = "3z4"
//输出: ["3z4", "3Z4"]
//
//输入: S = "12345"
//输出: ["12345"]
// 
//
// 注意： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 回溯算法

package com.sun.yelw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation{
    public static void main(String[] args) {
        Solution solution = new LetterCasePermutation().new Solution();

        System.out.println(solution.letterCasePermutation("2A3b"));
    }
  
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> list;
    public List<String> letterCasePermutation(String S) {
        list = new ArrayList<>();
        recurse(S.toCharArray(), 0);
        return list;
    }
    public void recurse(char[] chars, int idx){
        if(idx == chars.length){
            list.add(new String(chars));
            return;
        }
        recurse(chars, idx + 1);
        if(chars[idx] >= 'A'){
            chars[idx] = chars[idx] < 'a'? (char)(chars[idx] + 32): (char)(chars[idx] - 32);
            recurse(chars, idx + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
