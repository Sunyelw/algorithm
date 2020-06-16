//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。 
//
// 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法

package com.sun.yelw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class RestoreIpAddresses{
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
    }
  
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> res = new ArrayList <>();
    public List<String> restoreIpAddresses(String s) {

        if (s == null || s.length() > 12 || s.length() < 4) return Collections.emptyList();
        recursive(s.toCharArray(), 0, new ArrayList<>());
        return transToRes(res);
    }

    private void recursive(char[] arr, int pos, List<Integer> list) {

        if (list.size() == 4) {
            if (pos == arr.length) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        if (pos == arr.length) return;

        int all = arr[pos] == '0' ? 2 : 4;

        for (int i = 1; i < all; i++) {
            int target = getIntFromArray(arr, pos, i);
            if (target < 256) {
                list.add(target);
                recursive(arr, pos + i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private Integer getIntFromArray(char[] arr, int pos, int offset) {

        if (offset + pos > arr.length) return 256;

        char[] copy = new char[offset];
        System.arraycopy(arr, pos, copy, 0, offset);
        return Integer.valueOf(new String(copy));
    }

    private List<String> transToRes(List<List<Integer>> res) {

        List<String> rl = new ArrayList <>();
        for (List<Integer> ls : res) {
            String str = "";
            for (Integer i : ls) {
                str += i + ".";
            }
            rl.add(str.substring(0, str.length() - 1));
        }

        return rl;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
