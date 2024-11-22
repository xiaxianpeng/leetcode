package org.example.linkedlist.reverse;

import org.example.linkedlist.structure.ListNode;

/**
 * 25. K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * Created on 2024/11/22 17:58
 */
public class ReverseKGroup {

    /**
     * 翻转链表的 k 个一组节点。
     *
     * @param head 链表的头节点
     * @param k    每组的节点数
     * @return 翻转后的链表头节点
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // 找到当前组最后一个节点（下一个组的开始）
            ListNode kthNode = getKthNode(prevGroupEnd, k);
            if (kthNode == null) {
                break;// 不足 k 个节点，结束循环
            }

            // 记录下一个组的开始节点
            ListNode nextGroupStart = kthNode.next;
            // 翻转当前组的 k 个节点
            ListNode prev = null;
            ListNode curr = prevGroupEnd.next;
            while (curr != nextGroupStart) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // 当前组的起始节点（翻转前为组的开始，翻转后将成为组的末尾）
            ListNode currGroupStart = prevGroupEnd.next;
            // 将翻转后的当前组连接到前一个组的末尾
            prevGroupEnd.next = kthNode;// kthNode 是翻转后的当前组的新头节点
            // 将当前组的末尾节点连接到下一组的开始节点
            currGroupStart.next = nextGroupStart;// 连接下一组或剩余节点
            // 更新 prevGroupEnd 为当前组的末尾节点，为下一次迭代做准备
            prevGroupEnd = currGroupStart;

            System.out.println(dummy.next);
        }
        return dummy.next;
    }

    // 返回从 start 节点开始的第 k 个节点，如果不足 k 个节点则返回 null
    public static ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(head);
        System.out.println(reverseKGroup(head, 2));

        System.out.println("~~~~~~");

        ListNode head1 = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(head1);
        System.out.println(reverseKGroup(head1, 3));
    }
}
