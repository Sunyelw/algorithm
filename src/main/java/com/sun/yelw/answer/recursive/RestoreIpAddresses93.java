package com.sun.yelw.answer.recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.recursive
 * 类名称:     RestoreIpAddresses93
 * 类描述:
 * 创建人:     huangyang
 * 创建时间:   2020/6/15 9:04
 */
@SuppressWarnings("all")
public class RestoreIpAddresses93 {

    private static List<List<Integer>> res = new ArrayList <>();

    public static void main(String[] args){

        System.out.println(restoreIpAddresses("010010"));

    }

    // 1.思考循环参数
    /* 一定需要一个值来判断循环是否结束, 比如39里面target, 77里面的k, 这里就是最后一次取值的偏移量 */
    // <1>字符数组
    // <2>数据集合
    // <3>偏移量, 达到数组长度表示当前分支结束

    private static List<String> restoreIpAddresses(String s) {

        // s 的长度一定在 [4, 12] 之间
        if (s == null || s.length() > 12 || s.length() < 4) return Collections.emptyList();
        recursive(s.toCharArray(), 0, new ArrayList<>());
        return transToRes(res);
    }

    // 转化集合
    private static List<String> transToRes(List<List<Integer>> res) {

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

    // 递归函数
    private static void recursive(char[] arr, int pos, List<Integer> list) {

        // 2.列循环结束条件
        // <1>集合达到了4且位置移到了最后 为所需结果
        if (list.size() == 4) {
            if (pos == arr.length) {
                res.add(new ArrayList <>(list));
            }
            return;
        }

        // <2>先移到到尾部而数组还没有达到4
        if (pos == arr.length) return;

        // 因为IP每段最大255 也就是三位 这里就从当前偏移量依次往后取 1 2 3 位
        // 小于 256 的数创建一个分支

        // 需要考虑一种特殊情况 两位或三位数字不能以 0 开头
        // 当前字符为 0 时 仅取一位就行了
        int all = arr[pos] == '0' ? 2 : 4;

        for (int i = 1; i < all; i++) {
            int target = getIntFromArray(arr, pos, i);
            if (target < 256) {
                list.add(target);
                recursive(arr, pos + i, list);
                // 从上次递归出来,一定要移除最新插入的数据,不能影响新的分支
                list.remove(list.size() - 1);
            }
        }
    }

    private static Integer getIntFromArray(char[] arr, int pos, int offset) {

        // 超出部分直接给一个大于255的数 - 哨兵
        if (offset + pos > arr.length) return 256;

        char[] copy = new char[offset];
        System.arraycopy(arr, pos, copy, 0, offset);
        return Integer.valueOf(new String(copy));
    }
}
