package com.sun.yelw.answer.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.recursive
 * 类名称:     LetterCasePermutation787
 * 类描述:     784
 * 创建人:     huangyang
 * 创建时间:   2020/6/10 14:23
 */
@SuppressWarnings("all")
public class LetterCasePermutation784 {

    private static List<String> list = new ArrayList<>();;

    public static void main(String[] args){

        // ["YPkaXb","YPkaXB","YPkaxB","YPkaxb","YPkAxb","YPkAxB","YPkAXB","YPkAXb","YPKAXb","YPKAXB","YPKAxB","YPKAxb","YpKAxb","YpKAxB","YpKAXB","YpKAXb","YpkAXb","YpkAXB","YpkAxB","YpkAxb","ypkAxb","ypkAxB","ypkAXB","ypkAXb","ypKAXb","ypKAXB","ypKAxB","ypKAxb","yPKAxb","yPKAxB","yPKAXB","yPKAXb","yPkAXb","yPkAXB","yPkAxB","yPkAxb"]
        // ["ypkaxb","ypkaxB","ypkaXb","ypkaXB","ypkAxb","ypkAxB","ypkAXb","ypkAXB","ypKaxb","ypKaxB","ypKaXb","ypKaXB","ypKAxb","ypKAxB","ypKAXb","ypKAXB","yPkaxb","yPkaxB","yPkaXb","yPkaXB","yPkAxb","yPkAxB","yPkAXb","yPkAXB","yPKaxb","yPKaxB","yPKaXb","yPKaXB","yPKAxb","yPKAxB","yPKAXb","yPKAXB","Ypkaxb","YpkaxB","YpkaXb","YpkaXB","YpkAxb","YpkAxB","YpkAXb","YpkAXB","YpKaxb","YpKaxB","YpKaXb","YpKaXB","YpKAxb","YpKAxB","YpKAXb","YpKAXB","YPkaxb","YPkaxB","YPkaXb","YPkaXB","YPkAxb","YPkAxB","YPkAXb","YPkAXB","YPKaxb","YPKaxB","YPKaXb","YPKaXB","YPKAxb","YPKAxB","YPKAXb","YPKAXB"]

        // 2^6 = 64

        String[] arr1 = {"YPkaXb","YPkaXB","YPkaxB","YPkaxb","YPkAxb","YPkAxB","YPkAXB","YPkAXb","YPKAXb","YPKAXB","YPKAxB","YPKAxb","YpKAxb","YpKAxB","YpKAXB","YpKAXb","YpkAXb","YpkAXB","YpkAxB","YpkAxb","ypkAxb","ypkAxB","ypkAXB","ypkAXb","ypKAXb","ypKAXB","ypKAxB","ypKAxb","yPKAxb","yPKAxB","yPKAXB","yPKAXb","yPkAXb","yPkAXB","yPkAxB","yPkAxb"};
        String[] arr2 = {"ypkaxb","ypkaxB","ypkaXb","ypkaXB","ypkAxb","ypkAxB","ypkAXb","ypkAXB","ypKaxb","ypKaxB","ypKaXb","ypKaXB","ypKAxb","ypKAxB","ypKAXb","ypKAXB","yPkaxb","yPkaxB","yPkaXb","yPkaXB","yPkAxb","yPkAxB","yPkAXb","yPkAXB","yPKaxb","yPKaxB","yPKaXb","yPKaXB","yPKAxb","yPKAxB","yPKAXb","yPKAXB","Ypkaxb","YpkaxB","YpkaXb","YpkaXB","YpkAxb","YpkAxB","YpkAXb","YpkAXB","YpKaxb","YpKaxB","YpKaXb","YpKaXB","YpKAxb","YpKAxB","YpKAXb","YpKAXB","YPkaxb","YPkaxB","YPkaXb","YPkaXB","YPkAxb","YPkAxB","YPkAXb","YPkAXB","YPKaxb","YPKaxB","YPKaXb","YPKaXB","YPKAxb","YPKAxB","YPKAXb","YPKAXB"};

        System.out.println(arr1.length);
        System.out.println(arr2.length);

        System.out.println(letterCasePermutation1("YPkaXb"));
    }

    /* 方法1 换种写法 - 回溯思想 */
    private static List<String> letterCasePermutation1(String S) {
//        list = new ArrayList<>();
        recurse2(S.toCharArray(), 0);

        System.out.println(list.size());

        return list;
    }

    private static void recurse1(char[] chars, int idx){
        if (idx == chars.length) {
            list.add(new String(chars));
            return;
        }
        // 1.如果是字母,
        // <1>切换大小写
        // <2>不变
        // 2.如果不是字母, 跳过
        if (chars[idx] >= '0' && chars[idx] <= '9') {
            recurse1(chars, idx + 1);
        } else {
            recurse1(chars, idx + 1);
            chars[idx] ^= 0x20;
            recurse1(chars, idx + 1);
        }
    }

    private static void recurse2(char[] chars, int idx) {
        if (idx == chars.length) {
            list.add(new String(chars));
            return;
        }
        recurse2(chars, idx + 1);
        if (chars[idx] >= 'A') {
            chars[idx] ^= 0x20;
            recurse2(chars, idx + 1);
        }
    }


    /* 方法1 回溯 - DFS */
    private static List<String> letterCasePermutation(String S) {
        list = new ArrayList<>();
        recurse(S.toCharArray(), 0);
        return list;
    }
    private static void recurse(char[] chars, int idx){
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
