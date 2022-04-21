package org.example.linkedList.reverse;

import org.example.linkedList.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/22 12:03 AM
 *
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 */
public class Reverse {

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rev = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }

    public static ListNode reverseList(ListNode head) {
        // 前指针节点
        ListNode prev = null;
        // 当前指针节点
        ListNode cur = head;

        // 每次循环，将当前节点指向它前面的节点
        // 然后当前节点和前节点后移
        while (cur != null) {
            // 临时节点，将当前节点指向它前面的节点
            ListNode next = cur.next;
            // 将当前节点指向它前面的节点
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        ListNode reverse = reverseList(head);
        System.out.println(reverse);
    }
}
