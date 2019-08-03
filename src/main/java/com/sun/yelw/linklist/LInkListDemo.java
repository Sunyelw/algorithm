package com.sun.yelw.linklist;

import java.util.LinkedList;
import java.util.List;

/**
 * 项目名称:   MyDemo
 * 包:        com.example.demo.algorithm.linklist
 * 类名称:     LInkListDemo
 * 类描述:     链表相关算法
 * 创建人:     huangyang
 * 创建时间:   2019/8/1 15:29
 */
public class LInkListDemo {

    public static void main(String[] args){

        List<Integer> list = new LinkedList <>();
        list.add(1);

        // 初始化链表--单
        SingleList sList = new SingleList(new int[]{1, 3, 2, 5, 7, 10, 9});
        printNode(sList.getHeader());

        // 初始化链表--双
        initDouble(new int[]{1, 3, 2, 5, 7, 10, 9});

        // 反转单链表
        sList.reverseList();
        printNode(sList.getHeader());

        // 查询链表中间节点
        int data = sList.getMidNode();
        int data0 = sList.getMidNode0();
        System.out.println("d1:" + data);
        System.out.println("d0:" + data0);

        // 查询链表的倒数第三个节点
        int num = 3;
        System.out.println(num + "==" + sList.getLastIndexNode(num));

        // 判断链表是否有环


        // 判断环的起点

    }

    // only next
    private static Node initSingle(int[] arr) {
        // 哨兵
        Node sentinel = new Node();
        Node tmp = sentinel;
        for (int no : arr) {
            tmp.next = new Node(no);
            tmp = tmp.next;
        }
        return sentinel.next;
    }

    // prev and next
    // StackOverFlow
    private static Node initDouble(int[] arr) {
        Node sentinel = new Node();
        Node tmp = sentinel;
        for (int no : arr) {
            tmp.next = new Node(tmp, no, null);
            tmp = tmp.next;
        }
        return sentinel.next;
    }

    // 遍历输出
    private static void printNode(Node node) {
        if (null == node) return;
        System.out.println(node.data);
        printNode(node.next);
    }
}
