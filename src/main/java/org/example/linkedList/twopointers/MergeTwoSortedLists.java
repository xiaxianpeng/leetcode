package org.example.linkedList.twopointers;

import org.example.linkedList.structure.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/21 7:28 PM
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

    public static ListNode mergeTwoLists(ListNode L1, ListNode L2) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = L1;
        ListNode p2 = L2;
        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
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
