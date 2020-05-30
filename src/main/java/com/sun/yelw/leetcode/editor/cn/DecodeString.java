//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 示例: 
//
// 
//s = "3[a]2[bc]", 返回 "aaabcbc".
//s = "3[a2[c]]", 返回 "accaccacc".
//s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
// 
// Related Topics 栈 深度优先搜索

package com.sun.yelw.leetcode.editor.cn;

import java.util.Stack;

@SuppressWarnings("all")
public class DecodeString{
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();

        System.out.println(solution.decodeString("3[a]2[bc]")); // aaabcbc
        System.out.println(solution.decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
        System.out.println(solution.decodeString("3[a2[c]]")); // accaccacc

        //

    }
  
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {

        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack <>();
        StringBuilder curr = new StringBuilder();

        for (char c : arr) {

            // 1.非 ']' 字符直接入栈
            if (']' != c) {
                stack.push(c);
                continue;
            }

            // 2.拿到重复体
            curr = new StringBuilder();
            char strRel;
            while ('[' != (strRel = stack.pop())) {
                curr.insert(0, strRel);
            }

            // 3.拿到重复次数 需要注意数量是不止一位
            // 需要多一次字符入栈(因为这里是弹出来再判断是不是数字)
            StringBuilder num = new StringBuilder();
            char numRel = '0';
            while (!stack.isEmpty()
                    && (numRel = stack.pop()) >= '0'
                    && numRel <= '9') {
                num.insert(0, numRel);
            }
            // 非数字入栈, 注意这里还有可能是 '['
            if (numRel < '0' || numRel > '9') stack.push(numRel);

            // 4.将得到的字符重新按次数入栈
            for (int i = 0; i < Integer.valueOf(num.toString()); i++) {
                for (char c1 : curr.toString().toCharArray()) {
                    stack.push(c1);
                }
            }
        }

        // 5.所有字符出栈
        curr = new StringBuilder();
        while (!stack.isEmpty()) {
            curr.insert(0, stack.pop());
        }
        return curr.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
