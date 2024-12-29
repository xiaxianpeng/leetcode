package org.example.linkedlist;

import org.example.linkedlist.structure.ListNode;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * Created on 2024/12/8 15:09
 */
public class RotateList {

    /**
     * 将链表每个节点向右移动 k 个位置。
     *
     * @param head 链表的头节点
     * @param k    向右移动的步数
     * @return 旋转后的链表头节点
     * 算法思路：
     * 1. 首先计算链表的长度，并将链表连接成环。
     * 2. 计算实际需要旋转的步数 k % length。
     * 3. 找到新的尾节点的位置，即 (length - k) 步。
     * 4. 确定新的头节点，并断开环，完成旋转。
     * 时间复杂度：O(n)，其中 n 是链表的长度。
     * 空间复杂度：O(1)，只使用了常数级别的额外空间。
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            length++;
            current = current.next;
        }

        System.out.println("链表长度为: " + length);

        // 将链表尾节点连接到头节点，形成环
        current.next = head;
        System.out.println("已将链表尾节点连接到头节点，形成环。");


        // 计算实际需要旋转的步数
        k = k % length;
        System.out.println("实际需要旋转的步数 k = " + k);

        if (k == 0) {
            // 如果 k 为0，断开环并返回原链表
            current.next = null;
            return head;
        }

        // 使用双指针找到新的尾节点的位置，即 (length - k) 步
        int steps = length - k;
        System.out.println("找到新的尾节点的位置，需要移动 " + steps + " 步。");
        ListNode newTail = head;
        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
            System.out.println("移动到节点: " + newTail.val);
        }

        // 新的头节点为新的尾节点的下一个节点
        ListNode newHead = newTail.next;
        System.out.println("新的头节点是: " + newHead.val);

        // 断开环，新的尾节点的 next 指向 null
        newTail.next = null;
        System.out.println("已断开环，新的尾节点 " + newTail.val + " 的 next 指向 null。");

        return newHead;

    }

    public static void main(String[] args) {
        // [1,2,3,4,5], k = 2
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println("原链表: " + head1);
        ListNode rotated1 = rotateRight(head1, 2);
        System.out.println("旋转后链表: " + rotated1);
        System.out.println("-----------------------------------");

        // [0,1,2], k = 4
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        System.out.println("原链表: " + head2);
        ListNode rotated2 = rotateRight(head2, 4);
        System.out.println("旋转后链表: " + rotated2);
        System.out.println("-----------------------------------");

        // [], k = 1 (空链表)
        ListNode head3 = null;
        System.out.println("原链表: " + head3);
        ListNode rotated3 = rotateRight(head3, 1);
        System.out.println("旋转后链表: " + rotated3);
        System.out.println("-----------------------------------");

        // [1], k = 99 (单节点链表)
        ListNode head4 = new ListNode(1);
        System.out.println("原链表: " + head4);
        ListNode rotated4 = rotateRight(head4, 99);
        System.out.println("旋转后链表: " + rotated4);
    }
}
