package com.sun.yelw.answer.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     HappyNumber202
 * 类描述:     202
 * 创建人:     huangyang
 * 创建时间:   2020/5/31 8:30
 */
@SuppressWarnings("all")
public class HappyNumber202 {

    public static void main(String[] args){


//        System.out.println(isHappy1(1));
//        System.out.println(isHappy1(19));
        System.out.println(isHappy2(20));

//        System.out.println((int) '0'); // 48
//        System.out.println((int) '9'); // 57
//        System.out.println((int) 'a'); // 97
//        System.out.println((int) 'z'); // 122
//        System.out.println((int) 'A'); // 65
//        System.out.println((int) 'Z'); // 90

        System.out.println(2 ^ 3); // 1
        System.out.println(2 ^ 2); // 0
        System.out.println('a' ^ 0x20); // 65
        System.out.println('A' ^ 0x20); // 97

        System.out.println(10 ^ 32);
        System.out.println(42 ^ 32 ^ 32);
    }

    // https://leetcode-cn.com/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
    // 只有两种情况
    // 1. 返回1
    // 2. 形成环
    // PS 不会无限大

    /* 方法3 数学 */
    // TODO 3ms
    // 只有这一个循环 4→16→37→58→89→145→42→20→4
    // 两种情况
    // 1. 去往1的路上
    // 2. 去往这条链表的路上
    // 所以如果出现了这个链表中的数, 则死循环
    private static boolean isHappy2(int n) {
        Set<Integer> set = new HashSet <>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));
        for (;;) {
            if (set.contains(n)) return false;
            if ((n = getRel(n)) == 1) return true;
        }
    }


    // -> 链表找环 -> 快慢指针

    /* 方法2 快慢指针 */
    // TODO 1ms
    private static boolean isHappy1(int n) {
        int slow = n;
        int fast = n;
        for (;;) {
            slow = getRel(slow);
            fast = getRel(getRel(fast));
            if (fast == 1) return true;
            if (fast == slow) return false;
        }
    }


    /* 方法1 set集合 */
    private static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int x = n;
        for (;;) {
            set.add(x);
            x = getRel(x);
            if (x == 1) return true;
            if (set.contains(x)) return false;
        }
    }

    private static int getRel(int num) {
        int rel = 0, dig, n = num;
        while (n > 0) {
            dig = n % 10;
            rel += dig * dig;
            n /= 10;
        }
        return rel;
    }

}

