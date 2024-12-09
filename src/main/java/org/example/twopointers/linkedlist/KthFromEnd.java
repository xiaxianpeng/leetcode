package org.example.twopointers.linkedlist;

import org.example.linkedlist.structure.ListNode;

/**
 * 剑指Offer22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
 * 这个链表的倒数第 3 个节点是值为 4 的节点。
 * 示例：
 * 1
 * 2
 * 3
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */
public class KthFromEnd {

    /**
     * @param head head
     * @param k    k
     * @return 输出链表中倒数第k个节点
     * 果用 big O 表示法来计算时间复杂度，
     * 无论遍历一次链表和遍历两次链表的时间复杂度都是 O(N)，
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        // fast指针先向前移动k步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        // 同时移动fast和slow指针，直到fast指针到达链表末尾
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        int k = 2;
        ListNode fromEnd = getKthFromEnd(head, k);
        System.out.println(fromEnd);
    }
}
