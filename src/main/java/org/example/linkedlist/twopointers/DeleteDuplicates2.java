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
     *
     * @param head 链表头节点
     * @return 返回去除重复元素后的链表头节点
     * 算法思路：
     * 通过设置哨兵节点+双指针(prev+curr)
     * 当发现重复值时跳过所有重复节点，最终只保留不重复的节点
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 创建一个虚拟头节点，dummy.next指向head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // prev指针；指向当前不重复元素的前一个节点
        ListNode prev = dummy;
        // curr指针，遍历链表
        ListNode curr = head;

        // 遍历链表，当curr和curr.next均不为空进行比较
        while (curr != null && curr.next != null) {

            // 如果当前节点与下一个节点的值相同，则说明存在重复
            if (curr.val == curr.next.val) {
                // 重复值
                int duplicateVal = curr.val;
                // 向后跳过所有值为duplicateVal的节点
                while (curr != null && curr.val == duplicateVal) {
                    curr = curr.next;
                }
                // 将prev的next指向重复区间后的新位置
                prev.next = curr;
            } else {
                // 如果当前节点没有重复，更新prev和curr指针
                prev = prev.next;
                curr = curr.next;
            }
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
