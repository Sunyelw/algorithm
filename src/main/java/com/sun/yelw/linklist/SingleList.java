package com.sun.yelw.linklist;

import lombok.Data;

/**
 * 项目名称:   MyDemo
 * 包:        com.example.demo.algorithm.linklist
 * 类名称:     SingleList
 * 类描述:     单向链表
 * 创建人:     huangyang
 * 创建时间:   2019/8/2 8:13
 */
@Data
public class SingleList {

    // header
    private Node header;
    // size
    private int size;

    private SingleList () {
        // 初值
        header = new Node();
    }

    // 初始化
    SingleList(int[] arr) {

        this();

        if (null == arr || arr.length < 1) {
            throw new RuntimeException("arr is not illegal...");
        }

        header = new Node(arr[0]);
        Node tmp = header;
        for (int i = 1; i < arr.length; i++) {
            tmp.next = new Node(arr[i]);
            tmp = tmp.next;
        }

        size = arr.length;
    }

    @Override
    public String toString(){
        return "SingleList{" +
                "header=" + header +
                ", size=" + size +
                '}';
    }

    // 反转单链表
    public void reverseList() {

        if (size < 3) {
            throw new RuntimeException("single list size less than 3 is not necessary");
        }
        Node p, q, r;
        p = header;
        q = p.next;
        header.next = null;
        while (null != q) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }

        // 对象转换
        header = p;
    }

    // 查询链表中间节点
    public int getMidNode() {
        Node p, q;
        p = header;
        q = header;
        int np = 1;
        while (null != p.next) {
            p = p.next;
            np++;
            if (np % 2 == 0) q = q.next;
        }
        return q.data;
    }

    // 查询链表中间节点
    public int getMidNode0() {
        Node p, q;
        p = header;
        q = header;
        while (null != p.next && null != p.next.next) {
            p = p.next.next;
            q = q.next;
        }
        return q.data;
    }

    // 查询倒数 num 个节点
    public int getLastIndexNode(int num) {

        if (num > size || num < 0) {
            return -1;
        }

        Node p, q;
        p = header;
        q = header;
        int np = 1;
        while (null != p.next) {
            p = p.next;
            np++;
            if (np > num - 1) q = q.next;
        }
        return q.data;
    }

    // 判断链表是否包含指定元素
    public boolean findIndex(int data) {
        Node p = header;
        while (null != p && data != p.data) {
            p = p.next;
        }
        return null == p;
    }

    // 判断是否有环并找到环入口点
    public Node findLoopPoint() {

        Node fast = header;
        Node slow = header;

        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }

        // 不存在环
        if (null == fast || null == fast.next) return null;

        // 存在环，slow指回起点，fast指向相遇点
        slow = header;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // 再次相遇点即为环入口
        return slow;
    }

}
