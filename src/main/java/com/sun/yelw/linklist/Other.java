package com.sun.yelw.linklist;

/**
 * 包:        com.example.demo.algorithm.linklist
 * 类名称:     Other
 * 类描述:     其他算法
 * 创建人:     huangyang
 * 创建时间:   2019/8/3 16:47
 */
public class Other {

    public static void main(String[] args){

        int[] arr = new int[]{1, 24, 66, 76, 2, 89};

        // test
        System.out.println(find(arr, arr.length, 976));
        System.out.println(find0(arr, arr.length, 796));

        SingleList s1 = new SingleList(new int[]{1, 3, 5, 7, 9});
        SingleList s2 = new SingleList(new int[]{2, 3, 4, 6, 10, 100});

        LinkListDemo.printNode(mergeTwoList(s1.getHeader(), s2.getHeader()));

    }

    // find and find0
    // compare...
    // 使用哨兵优化代码, 此处的哨兵是替换后的最后一个元素

    private static int find(int[] arr, int n, int key) {
        int i = 0;

        // 每次循环要比较两次
        // i < n && arr[i] == key
        while (i < n) {
            if (arr[i] == key) {
                break;
            }
            i++;
        }
        return i < n ? i : -1;
    }

    private static int find0(int[] arr, int n, int key) {

        if (arr[n - 1] == key) return n - 1;

        int tmp = arr[n - 1];
        arr[n - 1] = key;

        // 每次循环只有一次比较
        // arr[i] != key
        int i = 0;
        while (arr[i] != key) i++;

        arr[n - 1] = tmp;

        return n - 1 == i ? -1 : i;
    }

    // 合并两个有序链表
    private static Node mergeTwoList(Node n1, Node n2) {
        // 哨兵节点
        Node sentinel = new Node(0);
        Node p = sentinel;

        while (null != n1 && null != n2) {
            if (n1.data < n2.data) {
                p.next = n1;
                n1 = n1.next;
            } else {
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }

        // 处理剩余的节点
        if (n1 == null) p.next = n2;
        if (n2 == null) p.next = n1;

        return sentinel.next;
    }

}
