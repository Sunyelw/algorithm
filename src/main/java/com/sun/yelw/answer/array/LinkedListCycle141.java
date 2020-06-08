package com.sun.yelw.answer.array;


/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     LinkedListCycle141
 * 类描述:
 * 创建人:     huangyang
 * 创建时间:   2020/6/5 14:36
 */
public class LinkedListCycle141 {

    public static void main(String[] args){

        String x = "1||||0";
        System.out.println(x.split("\\|").length);
        System.out.println(x.split("\\|", -1).length);

    }

    private static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        for (;;) {
            if (null == fast || (fast = fast.next) == null) return false;
            slow = slow.next;
            fast = fast.next;
            if (fast == slow) return true;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x){
        val = x;
        next = null;
    }
}