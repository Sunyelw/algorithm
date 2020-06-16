package com.sun.yelw.answer.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.recursive
 * 类名称:     Combinations77
 * 类描述:
 * 创建人:     huangyang
 * 创建时间:   2020/6/16 15:38
 * @see CombinationSum39
 */
public class Combinations77 {

    private static List<List<Integer>> list = new ArrayList <>();

    public static void main(String[] args){


        System.out.println(combine(4, 2));
    }

    private static List<List<Integer>> combine(int n, int k) {

        if (k <= 0 || n < 1) return list;
        process(1, n, k, new ArrayList<>());
        return list;
    }

    private static void process(int pos, int n, int k, List<Integer> ls) {

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
