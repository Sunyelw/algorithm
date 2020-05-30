package com.sun.yelw.answer.array;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     BullsAndCows299
 * 类描述:     leetcode 299
 * 创建人:     huangyang
 * 创建时间:   2020/5/28 9:35
 */
@SuppressWarnings("all")
public class BullsAndCows299 {

    public static void main(String[] args){

        // "1A3B"
        // "1A2B"
        System.out.println(getHint1("18074", "78105"));

    }

    // 纯数字 0-9
    // 两个数字字符串长度相等
    // A 公牛, B 奶牛

    /* 方法2 单数组 */
    // 双数组的情况最后算 cow 也是两个数组相减, 那么是不是可以用一个数组来存储
    private static String getHint1(String secret, String guess){
        int[] arr = new int[10];
        int bull = 0;
        int cow = 0;

        // 1.计算bull
        // 2.处理数组
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
                // 相等可以直接返回, 减少时间复杂度
                continue;
            }
            // 不相等, 记录下来
            // secret++
            arr[(int) secret.charAt(i) - '0']++;
            // guess--
            arr[(int) guess.charAt(i)  - '0']--;
        }

        // 3.计算正数和sum
        // cow = length - bull - sum
        // length: 字符串总长度
        // bull: 完全匹配的字符数量
        // sum: arr 数组中的正数和
        // PS:
        // arr 数组表示最终的匹配结果, 正数表示 secret 中多的 (也就是 guess 中没有的)
        // length 由三部分组成
        // 1. 完全匹配的       -> bull
        // 2. guess 中存在的   -> cow
        // 3. guess 中没有的   -> sum
        for (int a : arr) {
            if (a > 0) cow += a;
        }

        cow = secret.length() - bull - cow;
        return bull + "A" + cow + "B";
    }


    /* 方法1 双数组存储 */
    private static String getHint(String secret, String guess) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int bull = 0;
        int cow = 0;

        // 1.计算bull
        // 2.处理两个数组
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            }
            arr1[(int) secret.charAt(i) - '0']++;
            arr2[(int) guess.charAt(i)  - '0']++;
        }

        // 3.计算cow
        for (int i = 0; i < arr1.length; i++) {
            cow += Math.min(arr1[i], arr2[i]);
        }
        cow = cow - bull;
        return bull + "A" + cow + "B";
    }

}
