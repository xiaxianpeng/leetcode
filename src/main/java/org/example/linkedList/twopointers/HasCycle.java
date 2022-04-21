package org.example.linkedList.twopointers;

import org.example.linkedList.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/21 10:15 PM
 *
 * * 判断链表是否包含环
 * * https://labuladong.gitee.io/algo/2/17/16/#判断链表是否包含环
 * * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycle {

    public static boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;

            // 如果快慢指针相遇，说明有环
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4});
        head.next = head;

        boolean hasCycle = hasCycle(head);
        System.out.println(hasCycle);
    }
}
