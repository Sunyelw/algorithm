package com.sun.yelw.answer.array;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     LinkedListCycleIi142
 * 类描述:     142
 * 创建人:     huangyang
 * 创建时间:   2020/6/8 8:40
 */
@SuppressWarnings("all")
public class LinkedListCycleIi142 {

    public static void main(String[] args){

    }

    /* 快慢指针 */
    // 1.第一次相遇说明存在环
    // 2.slow置回原点,与fast再次相遇则为环入口
    private static ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        for (;;) {
            if (fast == null || (fast = fast.next) == null) break;
            fast = fast.next;
            slow = slow.next;
            if (slow == fast) break;
        }

        if (slow != fast) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
