package org.example.linkedList.twopointers;

import org.example.linkedList.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/21 10:15 PM
 * * 判断链表是否包含环
 * * https://labuladong.gitee.io/algo/2/17/16/#判断链表是否包含环
 * * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycle {

    public static boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head;
        ListNode fast = head;
        // 快指针走到末尾停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 如果快慢指针相遇，说明有环
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 创建一个含有环的链表用于测试
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        // 创建一个环
        node4.next = node2;

        System.out.println(hasCycle(head));
    }
}
