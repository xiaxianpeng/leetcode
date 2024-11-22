package org.example.linkedlist.twopointers;

import org.example.linkedlist.structure.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 */
public class MergeTwoSortedLists {

    /**
     * 合并两个有序链表
     *
     * @param L1 第一个有序链表的头节点
     * @param L2 第二个有序链表的头节点
     * @return 合并后的有序链表的头节点
     */
    public static ListNode mergeTwoLists(ListNode L1, ListNode L2) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = L1;
        ListNode p2 = L2;
        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 升序
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode L1 = new ListNode(new int[]{1, 2, 4});
        ListNode L2 = new ListNode(new int[]{1, 3, 4});
        ListNode listNode = mergeTwoLists(L1, L2);
        System.out.println(listNode);
    }
}
