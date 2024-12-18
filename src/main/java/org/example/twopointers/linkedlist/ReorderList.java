package org.example.twopointers.linkedlist;

import org.example.linkedlist.structure.ListNode;

/**
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * Created on 2024/12/18 10:50
 */
public class ReorderList {
    /**
     * 该方法实现了链表的重排，重排规则为：
     * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
     *
     * @param head 链表的头节点
     * @return void
     * 步骤如下：
     * 1. 使用快慢指针找到链表的中点；
     * 2. 将链表从中点分成两部分；
     * 3. 反转后半部分链表；
     * 4. 交替合并前后两部分链表。
     */
    public static void reorderList(ListNode head) {
        System.out.println("原始链表:" + head);
        // 1、使用快慢指针找到中点
        ListNode mid = getMid(head);

        // 2、获取后半部分链表
        ListNode second = mid.next;
        mid.next = null;
        System.out.println("后半部分链表:" + second);

        // 3、反转后半部分链表
        second = reverse(second);
        ListNode first = head;
        System.out.println("前半部分链表:" + first);
        System.out.println("后半部分链表:" + second);

        // 4、交替合并两个链表
        reorder(first, second);
        System.out.println("重排链表:" + head);
    }

    /**
     * 合并两个链表，交替合并：将前半部分链表和后半部分链表交替连接
     *
     * @param first  前半部分
     * @param second 后半部分链表(已反转)
     */
    private static void reorder(ListNode first, ListNode second) {
        // 交替合并两个链表，直到第二个链表为空
        while (second != null) {
            // 临时保存当前节点的下一个节点
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            // 将第一个链表的当前节点指向第二个链表的当前节点
            first.next = second;
            // 将第二个链表的当前节点指向第一个链表的下一个节点
            second.next = firstNext;

            // 移动到下一个节点
            first = firstNext;
            second = secondNext;
        }
    }

    /**
     * 使用快慢指针找到链表的中点
     *
     * @param head 链表的头节点
     * @return 返回链表的中点
     */
    private static ListNode getMid(ListNode head) {
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        // 快指针每次走两步，慢指针每次走一步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 返回中点节点
        return slow;
    }

    /**
     * 反转链表
     *
     * @param head 链表的头节点
     * @return 反转后的链表头节点
     */
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;// 反转后的链表头
        ListNode curr = head;// 当前节点

        // 迭代链表并反转节点的指向
        while (curr != null) {
            ListNode next = curr.next;// 临时保存当前节点的下一个节点
            curr.next = prev;// 将当前节点的 next 指向前一个节点
            prev = curr;// 移动 prev 到当前节点
            curr = next;// 移动到下一个节点
        }
        // 返回反转后的链表头
        return prev;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(new int[]{1, 2, 3, 4});
        reorderList(head1); // 输出：[1, 4, 2, 3]

        ListNode head2 = new ListNode(new int[]{1, 2, 3, 4, 5});
        reorderList(head2); // 输出：[1, 5, 2, 4, 3]
    }

}
