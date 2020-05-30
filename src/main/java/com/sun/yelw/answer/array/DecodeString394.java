package com.sun.yelw.answer.array;

import java.util.*;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     DecodeString394
 * 类描述:     lc 394
 * 创建人:     huangyang
 * 创建时间:   2020/5/29 8:17
 */
@SuppressWarnings("all")
public class DecodeString394 {

    public static void main(String[] args){
//        System.out.println(decodeString1("3[a]2[bc]")); // aaabcbc
//        System.out.println(decodeString1("2[abc]3[cd]ef")); // abcabccdcdcdef
//        System.out.println(decodeString1("3[a2[c]]")); // accaccacc
//        System.out.println(decodeString1("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
//        System.out.println('[' - '0');

        // 1.装箱类
        Character[] a1 = {'1', '2'};
        List<Character> list1 = Arrays.asList(a1);

        // 2.基本数据类型
        char[] a2 = "abcd".toCharArray();
        List<char[]> list2 = Arrays.asList(a2);

        // 3.String / 其他引用类型
        String[] a3 = {"a", "b"};
        List<String> list3 = Arrays.asList(a3);
    }

    /* 尝试 2 */
    // 转化 3[a2[c]] -> 3[acc] -> accaccacc 最后倒序遍历栈输出
    private static String decodeString1(String s) {

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
            // '['(91)
            // ']'(93)
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

    /* 尝试 1 fail */
    // 处理 '[' ']' 字符出栈入栈
    private static String decodeString(String s) {

        Stack<Character> stack = new Stack <>();
        char[] arr = s.toCharArray();

        StringBuilder curr;
        StringBuilder res = new StringBuilder();

        int x = 0;
        for (char c : arr) {
            // 非 ] 直接入栈
            if (']' != c) {
                stack.push(c);
                if ('[' == c && x > 0) x--;
                continue;
            }

            // 碰到 ] 则出栈直至碰到 [
            x++;
            if (x == 2) {
                curr = new StringBuilder(res);
                res = new StringBuilder();
            } else {
                curr = new StringBuilder();
            }
            char rel;
            while ((rel = stack.pop()) != '[') {
                curr.insert(0, String.valueOf(rel));
            }

            // 重复次数
            int num = stack.pop() - '0';
            for (int i = 0; i < num; i++) {
                res.append(curr);
            }
        }
        return res.toString();
    }

}
