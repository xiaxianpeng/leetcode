package org.example.linkedlist.sort;

import org.example.linkedlist.structure.ListNode;

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
 * Created on 2024/11/19 20:07
 */
public class MergeSort {

    /**
     * 排序链表
     * 使用归并排序方法，递归分割链表并合并。
     *
     * @param head 链表的头节点
     * @return 排序后的链表头节点
     */
    public static ListNode sortList(ListNode head) {
        // 基本情况：如果链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 使用快慢指针找到链表的中间节点，以进行拆分
        ListNode mid = getMiddle(head);

        ListNode left = head;
        ListNode right = mid.next;
        // 将链表在中间处断开
        mid.next = null;

        // 分别对左右部分进行递归排序
        left = sortList(left);
        right = sortList(right);

        // 将两个有序链表合并
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
        // 慢指针从head出发
        ListNode slow = head;
        // 快指针从head的下一个节点出发
        // 这样可以保证当fast到末尾时，slow正好在中点，便于均衡分割
        ListNode fast = head.next;

        // fast前进两步，slow前进一步
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle node found: " + slow.val);
        return slow;
    }

    /**
     * 合并两个有序链表。
     * 使用双指针来比较两个链表的头节点，将较小的节点依次接入新链表的尾部
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
