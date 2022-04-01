package org.example.linkedList;

/**
 * @author xianpeng.xia
 * on 2021/12/7 12:52 上午
 *
 * 单链表的中点
 * 技巧[快慢指针]
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/solution/
 */
public class MiddleNode {

    static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        // 快指针走两步，慢指针走一步
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{1, 2, 3, 4});
        ListNode middleNode = middleNode(listNode);
        System.out.println(middleNode.val);
    }
}
