package org.example.linkedList.twopointers;

import org.example.linkedList.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/21 8:35 PM
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

    public static ListNode removeNthFromEnd(ListNode head, int k) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 删除倒数第 k 个节点，要先找到倒数第 k+1 个节点
        ListNode x = findFromEnd(dummy, k + 1);

        // 删除倒数第 k 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    private static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        int k = 2;
        System.out.println(head);
        ListNode listNode = removeNthFromEnd(head, k);
        System.out.println(listNode);
    }
}
