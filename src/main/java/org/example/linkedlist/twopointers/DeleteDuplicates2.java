package org.example.linkedlist.twopointers;

import org.example.linkedlist.structure.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ，
 * 删除原始链表中所有重复数字的节点，只留下不同的数字 。
 * 返回 已排序的链表 。
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * Created on 2024/12/6 13:47
 */
public class DeleteDuplicates2 {

    /**
     * 删除排序链表中的所有重复元素，只留下不同的数字。
     * 思路：
     * 1. 使用一个虚拟头节点来简化边界情况处理（例如链表开头就是重复元素的情况）。
     * 2. 使用一个指针遍历链表，判断当前节点是否与下一个节点的值相同。
     * 3. 如果当前节点的值与下一个节点的值相同，则跳过所有重复元素。
     * 4. 如果不同，则将当前节点的值保留下来。
     *
     * @param head 链表头节点
     * @return 返回去除重复元素后的链表头节点
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // 创建虚拟头节点，方便处理链表头部的特殊情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy; // prev指针，指向当前不重复元素的前一个节点
        ListNode curr = head; // curr指针，遍历链表

        // 遍历链表
        while (curr != null) {

            // 如果当前节点与下一个节点的值相同，跳过所有重复节点
            if (curr.next != null && curr.next.val == curr.val) {
                // 找到所有重复的节点，跳过它们
                while (curr.next != null && curr.next.val == curr.val) {
                    curr = curr.next;// 跳过重复节点
                }
                // 将prev的next指向当前不重复节点的下一个节点
                prev.next = curr.next;
            } else {
                // 如果当前节点没有重复，更新prev指针
                prev = curr.next;
            }

            // 移动curr指针，继续遍历
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        System.out.println("Head:" + head);
        ListNode result = deleteDuplicates(head);
        System.out.println("Result:" + result);  // 输出：[1, 2, 5]

        ListNode head2 = new ListNode(new int[]{1, 1, 1, 2, 3});
        System.out.println("Head:" + head2);
        ListNode result2 = deleteDuplicates(head2);
        System.out.println("Result:" + result2);  // 输出：[2, 3]
    }
}
