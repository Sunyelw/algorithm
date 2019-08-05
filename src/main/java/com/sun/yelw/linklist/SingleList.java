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
    public Node getMidNode() {
        Node p, q;
        p = header;
        q = header;
        int np = 1;
        while (null != p.next) {
            p = p.next;
            np++;
            if (np % 2 == 0) q = q.next;
        }
        return q;
    }

    // 查询链表中间节点
    public Node getMidNode0() {
        Node p, q;
        p = header;
        q = header;
        while (null != p.next && null != p.next.next) {
            p = p.next.next;
            q = q.next;
        }
        return q;
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

    /**
     *
     * 判断环
     *
     对于这个问题我们可以采用“快慢指针”的方法。就是有两个指针fast和slow，

     开始的时候两个指针都指向链表头head，然后在每一步操作中slow向前走一步即：slow = slow->next，

     而fast每一步向前两步即：fast = fast->next->next。

     由于fast要比slow移动的快，如果有环，fast一定会先进入环，而slow后进入环。

     当两个指针都进入环之后，经过一定步的操作之后二者一定能够在环上相遇，并且此时slow还没有绕环一圈，

     也就是说一定是在slow走完第一圈之前相遇。


     slow每次向前走一步，fast向前追了两步，因此每一步操作后fast到slow的距离缩短了1步，这样继续下去就会使得

     两者之间的距离逐渐缩小：…、5、4、3、2、1、0 -> 相遇。

     又因为在同一个环中fast和slow之间的距离不会大于换的长度，

     因此到二者相遇的时候slow一定还没有走完一周

     （或者正好走完以后，这种情况出现在开始的时候fast和slow都在环的入口处）

     */


    /**
     *
     * 查找环入口
     *
     如果单链表有环，当slow指针和fast指针相遇时，slow指针还没有遍历完链表，

     而fast指针已经在环内循环n（n>=1）圈了，假设此时slow指针走了s步，fast指针走了2s步，

     r为fast在环内转了一圈的步数，a为从链表头到入口点的步数，b为从入口点到相遇点的步数，

     c为从相遇点再走c步到达入口点，L为整个链表的长度。

     slow指针走的步数：
     s = a + b

     fast指针走的步数：
     2s = s + n * r 即：s = n * r

     链表的长度：
     L = a + b + c = a + r

     由上可得：
     a + b = n * r = (n - 1) r + r

     而r = L - a，所以：

     a + b = (n - 1) r + L - a

     a = (n - 1)r + L - a - b

     而L - a - b = c，所以：

     a = (n -1) * r + c

     综上可得：从链表头到环入口点等于(n - 1)循环内环 + 相遇点到环入口点，

     于是在链表头和相遇点分别设置一个指针，同时出发，每次各走一步，它们必定会相遇，

     且第一次相遇的点就是环入口点。

     */
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

    /**
     *
     * 回文字符串
     *
     * 快慢指针，慢指针遍历的同时逆序，到中点位置比较俩链表是否相同
     *
     * 时间 O(N)
     *
     * 空间 O(1)
     *
     */
    public boolean isLoopString() {

        // 快慢
        Node fast = header;
        Node slow = header;

        // 反转
        Node q = header;
        Node r;

//        // 此处不能跟反转时一样赋值null，否则循环进不去
//        // 判断时可以判断尾节点的next为null 作为循环比较结束条件
//        header.next = null;

        // 找到中间节点并反转前半部分链表
        while (null != fast && null != fast.next) {
            // 定位中点位置
            fast = fast.next.next;
            // 反转前面的链表
            r = q.next;
            q.next = slow;
            slow = q;
            q = r;
        }

        // 数组长度为奇数时需要避开中间节点进行下一步比较
        if (null != fast) q = q.next;

        // 回文比较
        while (null != q) {
            if (! q.data.equals(slow.data)) return false;
            q = q.next;
            slow = slow.next;
        }
        return true;
    }
}
