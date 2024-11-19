package org.example.linkedList.sort;

import org.example.linkedList.structure.ListNode;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * 链接：https://leetcode.cn/problems/sort-list/description/
 * Created on 2024/11/19 20:07
 */
public class MergeSortLinkedList {

    public static ListNode sortList(ListNode head) {
        // 基本情况：如果链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 找到链表的中间节点
        ListNode mid = getMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;// 切断链表

        // 递归地排序左右两个子链表
        left = sortList(left);
        right = sortList(right);

        // 合并排序后的子链表
        return merge(left, right);
    }

    /**
     * 找到链表的中间节点。
     * 使用快慢指针法，快指针每次移动两步，慢指针每次移动一步。
     *
     * @param head 链表头节点。
     * @return 中间节点。
     */
    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle node found: " + slow.val);
        return slow;
    }

    /**
     * 合并两个已排序的链表。
     * 使用双指针方法来合并两个链表。
     *
     * @param l1 第一个已排序链表。
     * @param l2 第二个已排序链表。
     * @return 合并后的排序链表。
     */
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // 连接剩余的节点
        curr.next = l1 != null ? l1 : l2;
        System.out.println("Merged two lists:" + dummy.next);
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        System.out.println(head);
        // 排序链表
        ListNode sortedHead = sortList(head);
        System.out.println(sortedHead);
    }
}
