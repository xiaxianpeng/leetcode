package org.example.twopointers.linkedlist;

import org.example.linkedlist.structure.ListNode;

/**
 * 19. 删除链表的倒数第N个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class RemoveNthFromEnd {

    /**
     * 删除链表的倒数第 N 个节点
     *
     * @param head 链表的头节点
     * @param n    倒数第 n 个节点
     * @return 修改后的链表的头节点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        System.out.println("原链表: " + head);

        // 创建一个虚拟头节点，指向头节点，以便处理边界条件(如删除头节点)
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 初始化快慢指针，都指向虚拟头节点
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 快指针向前移动n+1步，以保持快慢指针之间相隔n步
        for (int i = 0; i < n + 1; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                // 如果n大于链表长度，直接返回原链表
                return head;
            }
        }

        // 同时移动快慢指针，直到快指针到达链表末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除慢指针的下一个节点
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        // 返回删除后的链表
        System.out.println("删除倒数第 " + n + " 个节点后: " + dummy.next);
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(new int[]{1, 2, 3, 4, 5});
        int k1 = 2;
        removeNthFromEnd(head1, k1);

        ListNode head2 = new ListNode(new int[]{1});
        int k2 = 1;
        removeNthFromEnd(head2, k2);

        ListNode head3 = new ListNode(new int[]{1, 2});
        int k3 = 1;
        removeNthFromEnd(head3, k3);

        // 边界情况: n 等于链表长度
        ListNode head4 = new ListNode(new int[]{1, 2, 3});
        int k4 = 3;
        removeNthFromEnd(head4, k4);
    }
}
