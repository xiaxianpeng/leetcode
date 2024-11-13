package org.example.twopointers.linkedlist;

import org.example.linkedList.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 示例1
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例2
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * Created on 2024/11/11 19:04
 */
public class RemoveDuplicatesFromSortedList {

    public static ListNode removeDuplicates(ListNode head) {
        // 如果链表为空，则直接返回 null
        if (head == null) {
            return null;
        }
        // 初始化 slow 和 fast 指针都指向头节点
        ListNode slow = head;
        ListNode fast = head;
        // 遍历链表
        while (fast != null) {
            // 当发现一个新的值（与 slow 指向的值不同）时
            if (fast.val != slow.val) {
                // 将 slow 的 next 指针指向当前 fast 的节点
                slow.next = fast;
                // 移动 slow 到下一个节点
                slow = slow.next;
            }
            // fast 指针始终向前移动
            fast = fast.next;
        }
        // 断开与后面重复的连接
        slow.next = null;
        // 返回链表的头节点，此时链表中已经删除了重复元素
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 2, 3, 3, 3, 4});
        System.out.println(head);
        ListNode listNode = removeDuplicates(head);
        System.out.println(listNode);
    }
}
