package com.sun.yelw.answer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     PascalsTriangleIi119
 * 类描述:     lc 119
 * 创建人:     huangyang
 * 创建时间:   2020/5/29 10:38
 */
@SuppressWarnings("all")
public class PascalsTriangleIi119 {

    public static void main(String[] args){

        System.out.println(getRow1(3));
    }

    /* 方法2 倒着进行 */
    private static List<Integer> getRow1(int rowIndex) {
        List<Integer> list = new ArrayList <>();
        if (rowIndex == 0) return list;
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
            list.add(1);
        }

        return list;
    }


    // 输入: 3
    // 输出: [1,3,3,1]
    private static List<Integer> getRow(int rowIndex) {
        // 示例从 0 开始算
        rowIndex++;
        if (rowIndex < 1) return new ArrayList<>();
        if (rowIndex == 1) return Collections.singletonList(1);
        if (rowIndex == 2) return Arrays.asList(1, 1);

        Integer[] curr = new Integer[rowIndex];
        // 初始化
        curr[0] = curr[rowIndex - 1] = 1;
        curr[1] = 1;
        for (int i = 3; i <= rowIndex; i++) {
            // 1 -> i - 2
            // 每次存储前一个数防止被覆盖
            int prev = 1;
            for (int j = 1; j < i - 1; j++) {
                int x = curr[j];
                curr[j] = prev + x;
                prev = x;
            }
            curr[i - 1] = 1;
        }

        return Arrays.asList(curr);
    }
}
